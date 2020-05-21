package Algorithm;

import java.math.BigInteger;

/**
 * @Author: YHQ
 * @Date: 2019/11/14 11:47
 */
public class minInteger {
    public String PrintMinNumber(int [] numbers) {
        String []str = new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        for (int t=0;t<str.length-1;t++){
            for (int i=0;i<str.length-1-t;i++){
                for(int j=0,k=0;j<str[i].length()&&k<str[i+1].length();){
                    if(str[i].charAt(j)==str[i+1].charAt(k)){
                        if(j+1==str[i].length()&&k+1<str[i+1].length())
                            k++;
                        else if(k+1==str[i+1].length()&&j+1<str[i].length())
                            j++;
                        else {
                            k++;
                            j++;
                        }
                    }
                    else if(str[i].charAt(j)<str[i+1].charAt(k))
                        break;
                    else {
                        swap(str,i,i+1);
                    }
                }
            }
        }
        String min = "";
        for (int i = 0; i < str.length; i++) {
            min += str[i];
        }
        return min;
    }
    public void find(int cur,int [] numbers,int n){

    }
    public void swap(String[] list, int k, int i) {//交换k和i
        String  temp;
        temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        boolean x[] = new boolean[100000];
        int count = 1;
        for (int i = 0; i < x.length; i++) {
            x[i]=false;
        }
        x[1] =true;
        for (int i=2;i<x.length;i+=2){
            x[i]=true;
        }
        for (int i=3;i<x.length;i+=3){
            x[i]=true;
        }
        for (int i=5;i<x.length;i+=5){
            x[i]=true;
        }
        for(int i=1;i<x.length;i++){
            if (x[i])
                count++;
            if(count==index)
                return i;
        }
        return 0;
    }
    public static void main(String args[]){
        minInteger t = new minInteger();
        int x[]={33334,3,3333332};
        System.out.println(t.PrintMinNumber(x));
        for (int i=1;i<150;i++)
            System.out.println(t.GetUglyNumber_Solution(i));




    }
}
