package Algorithm.蓝桥杯;

import java.math.BigInteger;

/**
 * @Author: YHQ
 * @Date: 2019/10/30 21:39
 */
public class 二十一位水仙花数 {
    public void find(){
        BigInteger []a={p(0),p(1),p(2),p(3),p(4),p(5),p(6),p(7),p(8),p(9)};
        int nn[]=new int[10];
        f(a,nn,0,0);
    }
    public void f(BigInteger []pw,int []nn,int cur,int use){   //nn记录每个数字出现次数  cur记录当前为哪个数字  use表示已经用了几个
        if (cur == 9){
            nn[9] = 21 - use;  //将剩下的全部为9
            count(pw,nn);   //判断是否符合
            return ;
        }
        for (int i = 0; i <21 - use; i++) {
            nn[cur] = i;
            f(pw,nn,cur+1,use+i);
        }
    }
    public void count(BigInteger []pw,int []nn){
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < 10; i++) {
            sum = sum.add(pw[i].multiply(BigInteger.valueOf(nn[i])));

        }
        String s=sum.toString();
        if(s.length()!=21) return ;
        int []nn2=new int[10];
        for (int i = 0; i < 21; i++) {   //统计s中每个数字出现的次数
            nn2[s.charAt(i)-'0']++;
        }
        for (int i = 0; i < 10; i++) {   //对比数字出现的次数
            if(nn[i]!=nn2[i]) return;
        }
        System.out.println(s);
    }
    public BigInteger p(int n){
        BigInteger temp =BigInteger.ONE;
        for (int i = 0; i <21; i++) {
            temp = temp.multiply(BigInteger.valueOf(n));
        }
        return temp;
    }
    public static void main(String args[]){
        二十一位水仙花数 a = new 二十一位水仙花数();
        a.find();
    }
}
