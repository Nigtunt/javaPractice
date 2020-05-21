package Algorithm.蓝桥杯;

import java.util.Scanner;

/**
 * 标题：地宫取宝
 *     X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
 *     地宫的入口在左上角，出口在右下角。
 *     小明被带到地宫的入口，国王要求他只能向右或向下行走。
 *     走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，
 *     小明就可以拿起它（当然，也可以不拿）。
 *     当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
 *     请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
 * 【数据格式】
 *     输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
 *     接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
 *     要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。
 */
public class 地宫取宝 {
    static int n,m,k;
    static int [][]num;
    static long [][][][]ha = new long[50][50][14][13];
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        n=s.nextInt();m=s.nextInt();k=s.nextInt();
        num = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                num[i][j] = s.nextInt();
            }
        }
        long ans = dfs(0,0,-1,0);
        System.out.println(ans);
    }

    private static long dfs(int i, int i1,int max,int count) {
        if (i==n||i1==m||count>k) return 0;
        if (ha[i][i1][max+1][count]!=0) return ha[i][i1][max+1][count];
        int cur = num[i][i1];
        int ans = 0;
        if (i==n-1&&i1==m-1){
            if (count==k) return 1;
            else if (cur>max&&count+1==k) return 1;
            return 0;
        }
        if (cur>max){
            ans += dfs(i,i1+1,cur,count+1);
            ans += dfs(i+1,i1,cur,count+1);
        }
        ans += dfs(i,i1+1,max,count);
        ans += dfs(i+1,i1,max,count);
        ha[i][i1][max+1][count] = ans%1000000007;
        return ans%1000000007;
    }
}
