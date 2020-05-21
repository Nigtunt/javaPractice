package Algorithm;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2019/12/22 18:51
 */
public class BankerAlgorithm {
    int n,m;
    private int Available[];
    private int Max[][];
    private int Allocation[][];
    private int Need[][];
    private String Process[];
    private String sourse[];

    private int Work[];
    private boolean Finish[];
    private int find(String name){
        for (int i=0;i<Process.length;i++){
            if (name.equals(Process[i]))
                return i;
        }
        return -1;
    }
    public void input(){
        Scanner s= new Scanner(System.in);
        System.out.println("输入进程数 资源类型数");
        int n = s.nextInt();
        int m = s.nextInt();
        Process = new String[n];
        sourse = new String[m];
        Available = new int[m];
        Max = new int[n][m];
        Allocation = new int[n][m];
        Need = new int[n][m];
        Work = new int[m];
        Finish = new boolean[n];
        System.out.println("输入各进程名");
        for (int i=0;i<n;i++){
            Process[i] = s.next();
        }
        System.out.println("输入各资源名和资源总数");
        for (int i=0;i<m;i++){
            sourse[i] = s.next();
            Available[i] = s.nextInt();
        }
        s.nextLine();
        System.out.println("输入各进程对各资源最大需求");
        for (int i=0;i<n;i++){
            String str = s.next();
            int index = find(str);
            for (int j=0;j<m;j++){
                Max[index][j] = s.nextInt();
            }
        }
        System.out.println("输入各进程已分配的资源");
        for (int i=0;i<n;i++){
            String str = s.next();
            int index = find(str);
            for (int j=0;j<m;j++){
                Allocation[index][j] = s.nextInt();
                Need[index][j] = Max[index][j] - Allocation[index][j];
                Available[j] -= Allocation[index][j];
            }
        }
    }
    public boolean isSafe(){
        Arrays.fill(Finish,false);
        System.arraycopy(Available,0,Work,0,Work.length);
        String str = "安全序列:";

        boolean haschange = true;
        print();
        while (!isAllDo(Finish)) {
            haschange = false;
            for (int i = 0; i < Process.length; i++) {
                if (Finish[i]) continue;
                if (coulddo(Work, Need[i])) {
                    System.out.print(Process[i] + " " + "work ");
                    str += Process[i] + " ";
                    for (int j = 0; j < Work.length; j++) {
                        System.out.print(Work[j] + " ");
                    }
                    System.out.print(" >= Need ");
                    for (int j = 0; j < Work.length; j++) {
                        System.out.print(Need[i][j] + " ");
                    }
                    System.out.println();
                    boolean f = false;
                    for (int j = 0; j < sourse.length; j++) {
                        if (Need[i][j] != 0) {
                            f = true;
                        }
                    }
                    if (!f) {
                        Finish[i] = true;
                    } else
                        for (int j = 0; j < Work.length; j++) {
                            Work[j] += Allocation[i][j];
                        }
                    Finish[i] = true;
                    haschange = true;
                }

            }
            if (!haschange) break;
        }
        if (isAllDo(Finish))
            System.out.println(str);
        return isAllDo(Finish);
    }
    private boolean coulddo(int [] work,int []need){
        for (int i=0;i<work.length;i++){
            if (work[i]<need[i])
                return false;
        }
        return true;
    }
    private boolean isAllDo(boolean[] f){
        for (boolean aF : f)
            if (!aF)
                return false;
            return true;
    }
    public void Request(){
        Scanner s = new Scanner(System.in);
        System.out.println("输入进程名 和请求资源的数目");
        String str = s.next();
        int []t= new int[sourse.length];
        for (int i = 0 ;i<t.length;i++){
            t[i] = s.nextInt();
        }
        if (!Request(str,t)){
            System.out.println("无法分配");
        }
        else {
            System.out.println("可以分配");
        }
    }
    private boolean Request(String name,int []t){
        int index = find(name);
        for (int i=0;i<t.length;i++){
            if (t[i]>Need[index][i]){
                System.out.println("大于需求");
                return false;
            }
            if (t[i]>Available[i]){
                System.out.println("大于当前可用资源");
                return false;
            }
        }
        boolean f = false;
        for (int i=0;i<t.length;i++){
            Available[i] -= t[i];
            Need[index][i] -= t[i];
            Allocation[index][i] += t[i];
            if (Need[index][i]!=0) f=true;
        }
        if (!f){
            for (int i=0;i<t.length;i++){
                Available[i] += Allocation[index][i];
            }
        }
        if (isSafe()){
            return true;
        }else {
            for (int i=0;i<t.length;i++){
                Available[i] += t[i];
                Need[index][i] += t[i];
                Allocation[index][i] -= t[i];
            }
            if (!f){
                for (int i=0;i<t.length;i++){
                    Available[i] -= Allocation[index][i];
                }
            }
            System.out.println("无法找到安全序列");
            return false;
        }
    }
    public void print(){
        System.out.println("\tMax\t\tAllocation\t\tNeed");
        System.out.print("\t");
        for (int i=0;i<sourse.length;i++){
            System.out.print(sourse[i]+" ");
        }
        System.out.println();
        for (int i=0;i<Process.length;i++){
            int index = find(Process[i]);
            System.out.print(Process[i] + "\t");
            for (int j=0;j<Max[index].length;j++)
                System.out.print(Max[index][j]+" ");
            System.out.print("\t\t");
            for (int j=0;j<Allocation[index].length;j++)
                System.out.print(Allocation[index][j]+" ");
            System.out.print("\t\t");
            for (int j=0;j<Need[index].length;j++)
                System.out.print(Need[index][j]+" ");
            System.out.print("\t");
            System.out.println();
        }
        System.out.println("Available");
        for (int j=0;j<Available.length;j++)
            System.out.print(Available[j]+" ");
        System.out.println();
    }
    public void meun(){
        System.out.println("1、输入数据");
        System.out.println("2、查看是否安全");
        System.out.println("3、进程请求数据");
        System.out.println("4、查看资源分配情况");
        System.out.println("5、退出");
    }
    public static void main(String args[]){
        BankerAlgorithm b= new BankerAlgorithm();
        Scanner s = new Scanner(System.in);
        a :{
            for (;;){
                b.meun();
                switch (s.nextInt()){
                    case 1: b.input();break;
                    case 2:System.out.println(b.isSafe()?"安全":"不安全");break;
                    case 3:b.Request();break;
                    case 4:b.print(); break;
                    case 5:break a;
                }
            }
        }
        s.close();
    }
}
