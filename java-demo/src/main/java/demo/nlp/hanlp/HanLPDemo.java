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
import java.util.PriorityQueue;

/**
 * @Author: zhouchao
 * @Date: 2021/05/27 11:08
 * @Description: 基于hanlp实现自然语言处理  https://github.com/hankcs/HanLP
 */
public class HanLPDemo {
    // 词典
    private static String trainFileName = "E:\\file\\taobao_jd_pdd_content.txt";
    // 训练后的词典文件
    private static String modelFileName = "E:\\file\\taobao_jd_pdd_content-msr.txt";
    // 产品列表文件
    private static String productFilePath = "E:\\file\\taobao_jd_pdd.txt";
    // 测试用的文本
    private static String text = "俏歌洗衣液3kgX4瓶促销组合装薰衣草去渍整箱批发机手洗香味持久";

    public static void main(String[] args) {
//        WordVectorModel wordVectorModel = trainOrLoadModel();
        WordVectorModel wordVectorModel = null;
        try {
            wordVectorModel = new WordVectorModel(modelFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);

        List<String> list = readProductFormFile();
        int i = 0;
        for (; i < list.size(); i++) {
            docVectorModel.addDocument(i, list.get(i));
        }
        docVectorModel.addDocument(i + 1, text);
        PriorityQueue pq = new PriorityQueue(127);
        for (String s : list) {
            float similarity = docVectorModel.similarity(text, s);
            ProductInfo productInfo = new ProductInfo(text, s, similarity);
            pq.offer(productInfo);
        }

        for (int j = 0; j < pq.size(); j++) {
            System.out.println(pq.poll());
        }
    }

    private static List<String> readProductFormFile() {
        List<String> result = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(productFilePath));
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
