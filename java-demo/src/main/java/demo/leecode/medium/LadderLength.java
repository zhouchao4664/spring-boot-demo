package demo.leecode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther: zhouc
 * @Date: 2020/12/9 23:56
 * @Description: https://leetcode-cn.com/problems/word-ladder/description/ 127. 单词接龙
 */
public class LadderLength {
    int count = Integer.MAX_VALUE;
    String empty = "";

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        selectLadderLength(beginWord, endWord, wordList, 1);
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    private int selectLadderLength(String beginWord, String endWord, List<String> wordList, int level) {
        //结束条件
        if (beginWord.equals(endWord)) return level;

        //流程处理，转换过的单词用""替换
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);

            //过滤掉已经转换过的单词
            if (empty.equals(word) || !isOneDiff(beginWord, word)) continue;
            wordList.remove(i);
            wordList.add(i, empty);
            int result = selectLadderLength(word, endWord, wordList, level + 1);
            if (result < count) count = result;
            //回溯
            wordList.remove(i);
            wordList.add(i, word);
        }

        return Integer.MAX_VALUE;
    }

    private boolean isOneDiff(String beginWord, String word) {
        char[] s = beginWord.toCharArray();
        int diffCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != word.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        Stream.of(words).forEach(s -> {
            wordList.add(s);
        });
        int result = new LadderLength().ladderLength(beginWord, endWord, wordList);

        System.out.println(result);
    }
}
