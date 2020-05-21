package Algorithm.蓝桥杯;

import java.util.*;

/**
 * 垒骰子
 * 赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
 * 经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
 * 我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
 * 假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 atm想计算一下有多少种不同的可能的垒骰子方式。
 * 两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
 * 由于方案数可能过多，请输出模 10^9 + 7 的结果。
 * 不要小看了 atm 的骰子数量哦～
 * 「输入格式」
 * 第一行两个整数 n m
 * n表示骰子数目
 * 接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。
 * 「输出格式」
 * 一行一个数，表示答案模 10^9 + 7 的结果。
 * 「样例输入」
 * 2 1
 * 1 2
 * 「样例输出」
 * 544
 */
public class 垒骰子 {
    final static int MOD = 1000000007;
    static int op[] = new int[7];
    static {
        op[1]=4;
        op[4]=1;
        op[3]=6;
        op[6]=3;
        op[2]=5;
        op[5]=2;
    }
    static long conlict[][] = new long[6][6];
    static long dp[][] = new long[2][7];
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt(),m = s.nextInt();
        for (int i = 0; i < 6; i++) {
            Arrays.fill(conlict[i],1);
        }
        for (int i = 0; i < m; i++) {
            int a = s.nextInt(),b=s.nextInt();
            conlict[op[a]-1][b-1] = 0;
            conlict[op[b]-1][a-1] = 0;
        }
        int k = n-1;
        long ans[][] = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                if (i==i1) ans[i][i] = 1;
            }
        }
        //T^(n-1)
        new Thread().start();
        while (k!=0){
            if ((k&1)==1){
                ans = m(ans,conlict);
            }
            conlict = m(conlict,conlict);
            k >>= 1;
        }
        long count = 0;
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                count = (count+ans[i][i1])%MOD;
            }
        }
        k = n;
        long t=4;
        //count*4^n
        while (k!=0){
            if ((k&1)==1) count = (count*t)%MOD;
            t = (t*t)%MOD;
            k >>=1 ;
        }
        System.out.println(count);
    }
    static long[][] m(long[][]m1,long[][]m2){
        long [][] ans = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                ans[i][i1] = 0;
                for (int i2 = 0; i2 < 6; i2++) {
                    ans[i][i1] =(ans[i][i1]+ m1[i][i2]*m2[i2][i1])%MOD;
                }
            }
        }
        return ans;
    }
}
