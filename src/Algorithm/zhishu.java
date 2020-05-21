package Algorithm;

import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2019/10/20 20:52
 */
public class zhishu {
    public void find(int n){
        boolean []prime=new boolean [n+1];
        for (int i=2;i<=n;i++){
            prime[i]=true;
        }
        for (int i = 2; i <n ; i++) {
            if(prime[i]){
               // System.out.print(i+" ");
                for(int j=i+i;j<n;j+=i)
                    prime[j]=false;
            }
        }
        if (prime[n])
            System.out.println("prime");
    }
    public void search(int x,int y){
        int sum = 0;
        for (int i=x;i<=y;i++){
            if(i%3==1&&i%5==3){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static void main(String args[]){
        zhishu s=new zhishu();
        Scanner scanner= new Scanner(System.in);
        s.search(200,800);
    }
}
