package demo.hanlp;

/**
 * @Author: zhouchao
 * @Date: 2021/06/11 18:16
 * @Description:
 */

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimHashUtil {
    //字符串
    private String tokens;
    /**
     * 字符产的hash值
     */
    private int hashbits = 64;
    /**
     * 分词后的hash数;
     */
    private BigInteger strSimHash;


    public SimHashUtil(String tokens) {
        this.tokens = tokens;
        this.strSimHash = this.simHash();
    }

    private SimHashUtil(String tokens, int hashbits) {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();
    }


    /**
     * 清除html标签
     *
     * @param content
     * @return
     */
    private String cleanResume(String content) {
        content = StringUtils.lowerCase(content);
        String[] strings = {" ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;"};
        for (String s : strings) {
            content = content.replaceAll(s, "");
        }
        return content;
    }


    /**
     * 这个是对整个字符串进行hash计算
     *
     * @return
     */
    private BigInteger simHash() {

        // cleanResume 删除一些特殊字符
        tokens = cleanResume(tokens);

        int[] v = new int[this.hashbits];

        // 对字符串进行分词
        List<Term> termList = StandardTokenizer.segment(this.tokens);
        StringBuffer sb = new StringBuffer();
        for (Term term : termList) {
            sb.append(term.word);
            sb.append(" ");
        }
        System.out.println(sb.toString());

        //对分词的一些特殊处理 : 比如: 根据词性添加权重 , 过滤掉标点符号 , 过滤超频词汇等;
        // 词性的权重
        Map<String, Integer> weightOfNature = new HashMap<String, Integer>();

        //给名词的权重是2;
        weightOfNature.put("n", 2);

        //停用的词性 如一些标点符号之类的;
        Map<String, String> stopNatures = new HashMap();
        stopNatures.put("w", "");

        //设定超频词汇的界限 ;
        int overCount = 5;
        Map<String, Integer> wordCount = new HashMap();

        for (Term term : termList) {
            //分词字符串
            String word = term.word;

            // 分词属性;
            String nature = term.nature.toString();

            //  过滤超频词
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                if (count > overCount) {
                    continue;
                }
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }

            // 过滤停用词性
            if (stopNatures.containsKey(nature)) {
                continue;
            }

            // 2、将每一个分词hash为一组固定长度的数列.比如 64bit 的一个整数.
            BigInteger t = this.hash(word);
            for (int i = 0; i < this.hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                /**
                 * 3、建立一个长度为64的整数数组(假设要生成64位的数字指纹,也可以是其它数字),
                 * 对每一个分词hash后的数列进行判断,如果是1000...1,那么数组的第一位和末尾一位加1,
                 * 中间的62位减一,也就是说,逢1加1,逢0减1.一直到把所有的分词hash数列全部判断完毕.
                 */
                //添加权重
                int weight = 1;
                if (weightOfNature.containsKey(nature)) {
                    weight = weightOfNature.get(nature);
                }
                if (t.and(bitmask).signum() != 0) {
                    // 这里是计算整个文档的所有特征的向量和
                    v[i] += weight;
                } else {
                    v[i] -= weight;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < this.hashbits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;
    }


    /**
     * 对单个的分词进行hash计算;
     *
     * @param source
     * @return
     */
    private BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            /**
             * 当sourece 的长度过短，会导致hash算法失效，因此需要对过短的词补偿
             */
            while (source.length() < 3) {
                source = source + source.charAt(0);
            }
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    /**
     * 计算海明距离,海明距离越小说明越相似;
     *
     * @param other
     * @return
     */
    private int hammingDistance(SimHashUtil other) {
        BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
                new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);
        int tot = 0;
        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }


    public double getSemblance(SimHashUtil s2) {
        double i = (double) this.hammingDistance(s2);
        return 1 - i / this.hashbits;
    }

    public static float getSemblance(String text1, String text2) {
        double result = new SimHashUtil(text1, 64).getSemblance(new SimHashUtil(text2, 64));
        return new BigDecimal(String.valueOf(result)).floatValue();
    }

    public static void main(String[] args) {

        String s1 = "小黄鸭芒果果汁软糖QQ糖橡皮糖3D造型70g4包";
        String s2 = "百草味爆浆果汁软糖45gx2袋糖果散装零食橡皮水果qq糖休闲小零食";
        long l3 = System.currentTimeMillis();
        SimHashUtil hash1 = new SimHashUtil(s1, 64);
        SimHashUtil hash2 = new SimHashUtil(s2, 64);
        System.out.println("======================================");
        System.out.println("海明距离：" + hash1.hammingDistance(hash2));
        System.out.println("文本相似度：" + hash1.getSemblance(hash2));
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
        System.out.println("======================================");

        System.out.println(SimHashUtil.getSemblance(s1, s2));
    }
}
