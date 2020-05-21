package Algorithm.蓝桥杯;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 标题：矩阵翻硬币
 *     小明先把硬币摆成了一个 n 行 m 列的矩阵。
 *     随后，小明对每一个硬币分别进行一次 Q 操作。
 *     对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。
 *     其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
 *     当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
 *     小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
 *     聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。
 *     然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。
 * 【数据格式】
 *     输入数据包含一行，两个正整数 n m，含义见题目描述。
 *     输出一个正整数，表示最开始有多少枚硬币是反面朝上的。
 * 【样例输入】
 * 2 3
 * 【样例输出】
 * 1
 * 【数据规模】
 * 对于10%的数据，n、m <= 10^3；
 * 对于20%的数据，n、m <= 10^7；
 * 对于40%的数据，n、m <= 10^15；
 * 对于10%的数据，n、m <= 10^1000（10的1000次方）。
 */
public class 整数开方 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] str1 = str.split(" ");
        System.out.println(sqrt(str1[0]).multiply(sqrt(str1[1])));
    }

    private static BigInteger sqrt(String str){
        int len = str.length();
        if (len%2==0){
            len = len /2 ;
        }else {
            len = len/2 +1 ;
        }
        char sArr[] = new char[len];
        Arrays.fill(sArr,'0');
        BigInteger target = new BigInteger(str);

        for (int pos = 0;pos<len;pos++){
            for (char c = '1';c<='9';c++){
                sArr[pos] = c;
                if (new BigInteger(String.valueOf(sArr)).pow(2).compareTo(target)>0){
                    sArr[pos] -= 1;
                    break;
                }
            }
        }
        return new BigInteger(String.valueOf(sArr));
    }
    public static void test(int n,int m){
        boolean num[][] = new boolean[n+1][m+1];
        for (int x=1;x<n+1;x++){
            for (int y=1;y<m+1;y++){
                for (int i=0;;i++){
                    for (int j=0;;j++){
                        if (i*x<n+1&&j*y<m+1)
                            num[i*x][j*y] = !num[i*x][j*y];
                        else break;
                    }
                    if (i*x>=n+1) break;
                }
            }
        }
        int count = 0;
        for (int x=1;x<n+1;x++) {
            for (int y = 1; y < m + 1; y++) {
                if (num[x][y]) count++;
            }
        }
        System.out.println(n+"*"+m+":"+count);
    }
}
