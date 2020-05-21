package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: YHQ
 * @Date: 2019/11/5 20:51
 */
public class 字符串的排列 {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        per(str.toCharArray(),0,str.length()-1);
        Collections.sort(list);
        return list;
    }
    public void per(char []str,int k, int n){
        if (k==n ){
            String temp = new String(str);
            int []x = {1,5,23,4};
            if (!list.contains(temp))
                list.add(temp);

        }else {
            for (int i = k ;i<=n ;i++){
                swap(str,k,i);
                per(str,k+1,n);
                swap(str,k,i);
            }
        }
    }
    public void swap(char[] list, int k, int i) {//交换k和i
        char temp;
        temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }
    public int numTilePossibilities(String tiles) {
        int count[] = new int [26];
        for(int i=0;i<tiles.length();i++){
            count[tiles.charAt(i)-'A']++;
        }
        return dfs(count);
    }
    int res = 0;
    public int dfs(int []count){
        for(int i=0;i<count.length;i++){
            if(count[i]==0)
                continue;
            res +=1;
            count[i]--;
            res = dfs(count);
            count[i]++;
        }
        return res;
    }
    public static void main(String args[]){
        字符串的排列 a = new 字符串的排列();
//        ArrayList list = a.Permutation("abc" );
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+" ");
//            if (i==10||i==21)System.out.println();
//        }
        System.out.println(a.numTilePossibilities("AAB"));
        System.out.println(a.numTilePossibilities("AAABBC"));
    }
}
