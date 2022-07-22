//package demo.nlp.hanlp;
//
//
//import org.thymeleaf.util.SetUtils;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class ChineseStringMatcher {
//    /**
//     *
//     */
//    public static final char MATCH = '十';
//    public static final char MISMATCH = '口';
//
//    /**
//     *
//     */
//    private static final char[] cnSignArr = "。？！，、；：“” ‘’「」『』（）〔〕【】—﹏…～·《》〈〉".toCharArray();
//    private static final char[] enSignArr = "`!@#$%^&*()_+~-=[]\\;',./{}|:\"<>?".toCharArray();
//
//    /**
//     *
//     */
//    private String originString;
//    private String matchString;
//
//    private String orgWords;
//    private String mtcWords;
//
//    /**
//     *
//     */
//    private char[] org;
//    private char[] mtc;
//
//
//    /**
//     *
//     */
//    private int[] indicator;
//
//
//    /**
//     *
//     */
//    private double matchingRate;
//    private double accuracyRate;
//    private int absent;
//    private int excess;
//
//
//    public ChineseStringMatcher(String orignText, String matchText) {
//        super();
//
//        this.originString = orignText;
//        this.matchString = matchText;
//
//        //init variables
//        initVariables();
//
//        //do process
//        doProcess();
//    }
//
//
//    private void initVariables() {
//        //init char array
//
//        orgWords = clearNonWordChar(originString);
//        mtcWords = clearNonWordChar(matchString);
//
//        org = orgWords.toCharArray();
//        mtc = mtcWords.toCharArray();
//
//        //init indicator
//        int i=0;
//        indicator = new int[mtc.length]; // init with 0
//
//    }
//
//
//    public int[] getIndicator() {
//        return indicator;
//    }
//
//
//    public double getMatchingRate() {
//        return matchingRate;
//    }
//
//    public double getAccuracyRate()
//    {
//        return accuracyRate;
//    }
//
//
//    public int getAbsent() {
//        return absent;
//    }
//
//
//    public int getExcess() {
//        return excess;
//    }
//
//    public String getOriginString() {
//        return originString;
//    }
//
//
//    public String getMatchString() {
//        return matchString;
//    }
//
//
//    public char[] getOrg() {
//        return org;
//    }
//
//
//    public char[] getMtc() {
//        return mtc;
//    }
//
//    private String clearNonWordChar(String str)
//    {
//        for(int i=0;i<cnSignArr.length;i++)
//            str = str.replace(""+cnSignArr[i], "");
//        for(int i=0;i<enSignArr.length;i++)
//            str = str.replace(""+enSignArr[i], "");
//        return str;
//    }
//
//    public void doProcess()
//    {
//        int index = 0;
//        double matchCount = 0;
//        for(int i=0;i<mtc.length;i++)
//        {
//            for (int j = index; j < org.length; j++)
//            {
//                if(mtc[i] == org[j])
//                {
//                    index++;
//                    indicator[i] = 1;
//                    matchCount++;
//                    break;
//                }
//            }
//        }
//
//        matchingRate = matchCount/orgWords.length()*100;
//        accuracyRate = matchingRate * matchCount / mtcWords.length();
//
//        if(orgWords.length() > matchCount) {
//            absent = orgWords.length() - (int) matchCount;
//        }
//        if(mtcWords.length() - (int)matchCount != 0){
//            excess = mtcWords.length() - (int)matchCount;
//        }
//
//
//    }
//
//    public void printResult()
//    {
//        System.out.println(" - - - - Start - - - - ");
//        System.out.printf("%-8s%8s\n","原串：",originString);
//        System.out.printf("%-8s%8s\n","目标串：",matchString);
//
//        System.out.println();
//        System.out.printf("%-16s\n","匹配结果："
//                + "");
//        for(int i=0;i<mtc.length;i++)
//        {
//            System.out.printf("%2c",mtc[i]);
//        }
//        System.out.println();
//        for(int i:indicator)
//        {
//            System.out.printf("%2c",indicator[i]==0?MATCH:MISMATCH);
//        }
//        System.out.println();
//
//        System.out.printf("匹配率：%.2f%%\n",matchingRate);
//        System.out.printf("准确率：%.2f%%\n",accuracyRate);
//        System.out.println();
//        if(absent != 0) {
//            System.out.printf("\n比原串少%d个字\n", absent);
//        }
//        if(excess != 0) {
//            System.out.printf("\n比原串多%d个字\n", excess);
//        }
//        System.out.println(" - - - - Start - - - - ");
//    }
//
//    /**
//     * 集合的交集与集合的并集的比例.
//     * @param a
//     * @param b
//     * @return
//     */
//    public static float jaccard(String a, String b) {
//        if (a == null && b == null) {
//            return 1f;
//        }
//        // 都为空相似度为 1
//        if (a == null || b == null) {
//            return 0f;
//        }
//        Set<Integer> aChar = a.chars().boxed().collect(Collectors.toSet());
//        Set<Integer> bChar = b.chars().boxed().collect(Collectors.toSet());
//        // 交集数量
//        int intersection = SetUtils.intersection(aChar, bChar).size();
//        if (intersection == 0) return 0;
//        // 并集数量
//        int union = SetUtils.union(aChar, bChar).size();
//        return ((float) intersection) / (float)union;
////        return 0f;
//    }
//
//    public static void main(String[] arg)
//    {
//        String orignText ="珀莱雅源力精华液面部补水保湿修护收缩毛孔泊莱雅旗舰店官方正品";
//        String matcherText ="珀莱雅源力精华液面部补水保湿修护收缩毛孔泊莱雅旗舰店官方正品";
////        System.out.println("hello world!");
////        ChineseStringMatcher matcher =
////                new ChineseStringMatcher(orignText, "洗发露");
////        matcher.printResult();
////
////        new ChineseStringMatcher(orignText, "精华素").printResult();
////        new ChineseStringMatcher(orignText, "飘柔人参滋养").printResult();
////        new ChineseStringMatcher(orignText, "飘柔洗发露洗发水750ml人参滋养修护香氛柔顺改善毛躁家庭装精华护理系列男女士通用 精油润养柔顺洗发露750ml(干枯毛躁)").printResult();
//        float jaccard = ChineseStringMatcher.jaccard(orignText, matcherText);
//        System.out.println(jaccard);
//    }
//
//}
