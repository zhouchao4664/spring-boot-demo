package demo.analyzer;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author: zhouchao
 * @Date: 2021/07/15 10:20
 * @Description:
 */
public class IkAnalyzerDemo {
    public static void main(String[] args) throws IOException {
        String text = "我就想试一试分词器，别整那些没用的东西";
        StringReader stringReader = new StringReader(text);
        IKSegmenter ikSegmenter = new IKSegmenter(stringReader, true);
        Lexeme lexeme = null;
        while ((lexeme = ikSegmenter.next()) != null) {
            System.out.print(lexeme.getLexemeText() + "|");
        }
        System.out.println();
        System.out.println("=========智能分词完毕");


        StringReader sr = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(sr, false);
        Lexeme lexe = null;
        while ((lexe = ik.next()) != null) {
            System.out.print(lexe.getLexemeText() + "|");
        }
        System.out.println();
        System.out.println("=========细粒度分词完毕");
    }
}
