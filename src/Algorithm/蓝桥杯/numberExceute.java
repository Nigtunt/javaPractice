package Algorithm.蓝桥杯;

import java.util.LinkedList;

public class numberExceute {
    //13的13次方
    public static void numberLastThree(){
        int temp=1;
        for (int i = 0; i <13; i++) {
            temp=(temp*13)%1000;
        }
        System.out.println(temp);
    }
    //100!尾有几个零
    public static void number$Zreo(){
        int count=0;
        for (int i = 5; i <= 100; i+=5) {
            count++;
        }
        System.out.println(count);
    }
    //约瑟夫问题
    public static void yuesefu(int n,int m){
        if(n==1) {
            System.out.println(0);
            return ;
        }
        int []y=new int[n];
        for (int i = 0; i <n; i++) {
            y[i]=i;
        }
        int temp=-1; //temp表示点名到了几号下标
        int len=n;   //当前人数
        while(true){
            for (int i=0;i<m;i++){
                temp++;      //点一次
                temp%=len;   //环
            }
            if (len==2){
                System.out.println(y[(++temp)%2]+1);  //就剩两人
                return;
            }else
                len--;
            for (int i = temp; i <len; i++) {
                y[i]=y[i+1];
            }
            temp--; //由于上一个此位置的人已出局  所以temp返回上一个位置
        }
    }
    public static void main(String args[]){
        numberLastThree();
        number$Zreo();
        yuesefu(10,3);
    }
}
