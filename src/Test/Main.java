package Test;

import java.math.BigInteger;

public class Main {
static int CCC = 0;
    public static void main(String[] args) {
//        f(0,0);
//        System.out.println(CCC);
    }

    static void f(int k,int count){
        if (count>14) return;
        if (k==13&&count==13){
            CCC++;
            return;
        }
        for (int j=0;j<5;j++){
            f(k+1,count+j);
        }
    }


}
