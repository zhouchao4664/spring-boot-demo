package demo.nlp.hanlp;

import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/05/27 11:08
 * @Description: 基于hanlp实现自然语言处理  https://github.com/hankcs/HanLP
 */
public class BatchHanLPDemo {
    // 词典
    private static String trainFileName = "E:\\file\\taobao_jd_pdd_content.txt";
    // 训练后的词典文件
    private static String modelFileName = "E:\\file\\taobao_jd_pdd_content-msr.txt";

    // 产品列表文件
    private static String productFilePath = "E:\\file\\batch_text_case.txt";
    // 测试用的keyword文本文件
    private static String textFilePath = "E:\\file\\batch_text.txt";

    // 步长
    private static int step = 10;

    public static void main(String[] args) {
//        WordVectorModel wordVectorModel = trainOrLoadModel();
        WordVectorModel wordVectorModel = null;
        try {
            wordVectorModel = new WordVectorModel(modelFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);

        List<String> productList = readFile(productFilePath);
        List<String> textList = readFile(textFilePath);

        // 加载文档
        loadDocument(docVectorModel, productList, textList);

        List<ProductInfo> productInfoList = new ArrayList<>(productList.size());
        for (int i = 0; i < textList.size(); i++) {
            String text = textList.get(i);
            for (int j = 0; j < step; j++) {
                String product = productList.get(j + (i * step));
                float similarity = docVectorModel.similarity(text, product);
                ProductInfo productInfo = new ProductInfo(text, product, similarity);
                productInfoList.add(productInfo);
            }
        }

        for (ProductInfo productInfo : productInfoList) {
            System.out.println(productInfo);
        }
    }

    private static void loadDocument(DocVectorModel docVectorModel, List<String> productList, List<String> textList) {
        int i = 0;
        int j = 0;
        for (; i < productList.size(); i++) {
            docVectorModel.addDocument(i, productList.get(i));
        }
        for (; j < textList.size(); j++) {
            docVectorModel.addDocument(i + j, textList.get(j));
        }
    }

    private static List<String> readFile(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String content = null;
            while ((content = br.readLine()) != null) {
                result.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    static class ProductInfo implements Comparable<ProductInfo> {
        private String text;
        private String content;
        private float similarity;

        @Override
        public int compareTo(ProductInfo o) {
            return this.similarity < o.similarity ? 1 : -1;
        }
    }


    private static WordVectorModel trainOrLoadModel() {
        Word2VecTrainer trainerBuilder = new Word2VecTrainer();
        WordVectorModel wordVectorModel = trainerBuilder.train(trainFileName, modelFileName);
        return wordVectorModel;
    }
}
