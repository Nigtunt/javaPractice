package Algorithm.Leetcode;

import java.util.*;

/**
 * @Author: YHQ
 * @Date: 2019/12/16 21:28
 */
public class 单词检查 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s,0,wordDict,new Boolean[s.length()]);
    }

    private boolean wordBreakHelper(String s,int n, List<String> wordDict,Boolean booleans[]) {
        if (s.length() == n) return true;
        if (booleans[n]!=null){
            return booleans[n];
        }
        for(int i=n+1;i<=s.length();i++){
            if (wordDict.contains(s.substring(n,i)))
                if (wordBreakHelper(s,i,wordDict,booleans))
                    return booleans[n]=true;
        }
        return booleans[n]=false;
    }
    public List<String> wordBreakII(String s, List<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
    public static void main(String args[]){
        单词检查 c = new 单词检查();
        List<String> dic = new ArrayList<>();
        dic.add("apple");
        dic.add("pen");
        dic.add("applepen");
        dic.add("pineapple");
        dic.add("pine");

        c.wordBreak("pineapplepenapple",dic);

    }
}
