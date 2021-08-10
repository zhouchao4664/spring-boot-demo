package demo.nlp.hanlp;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NotionalTokenizer;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/06/10 12:00
 * @Description:
 */
public class NLPSegmentDemo {

    private static String productFilePath = "E:\\file\\taobao_jd_pdd.txt";

    private static String contentFilePath = "E:\\file\\taobao_jd_pdd_content.txt";

    public static void main(String[] args) {
        NLPSegmentDemo.segmentFormFile();
    }

    private static List<String> segmentFormFile() {
        List<String> result = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(productFilePath));
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            File file = new File(contentFilePath);
            if (!file.exists()){
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            String content = null;

            StringBuffer sb = new StringBuffer();
            while ((content = br.readLine()) != null) {
                sb.delete(0,sb.length());
                if (StringUtils.isEmpty(content)) {
                    continue;
                }
                List<Term> list = NotionalTokenizer.segment(content);
                if (!CollectionUtils.isEmpty(list)) {
                    for (Term term : list) {
                        sb.append(term.word);
                        sb.append("  ");
                    }
                }
                bw.write(sb.toString());
                bw.flush();
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
