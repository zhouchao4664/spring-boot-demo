package demo.leecode.medium;


/**
 * @Auther: zhouc
 * @Date: 2020/12/8 23:12
 * @Description: https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description 433. 最小基因变化
 */
public class MinMutation {

    int count = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        int level = 0;
        selectMinMutation( start,  end,  bank,level);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int selectMinMutation(String start, String end, String[] bank, int level) {
        //结束条件
        if(start.equals(end)){
            return level;
        }

        //循环遍历数组,如果使用过就设为null
        for (int i = 0; i < bank.length; i++) {
            String b = bank[i];
            if (b == null||!isOneDiff(start,b)) continue;

            // 如果结果大于-1，证明找到了 回溯
            bank[i] = null;
            int result = selectMinMutation(b,end,bank,level+1);
            if (result < count){
                count = result;
            }
            bank[i] = b;
        }

        return Integer.MAX_VALUE;
    }
    private boolean isOneDiff(String s1,String s2){
        if (s1.length()!=s2.length()) return false;

        int diffCount = 0;
        for (int i = 0; i < s1.toCharArray().length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCount++;
            if (diffCount>1) return false;
        }

        return diffCount == 1;
    }

    public static void main(String[] args) {
        String start = "AAAACCCC";
        String end = "CCCCCCCC";
        String[] bank = {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        int result = new MinMutation().minMutation(start,end,bank);

        System.out.println(result);
    }
}
