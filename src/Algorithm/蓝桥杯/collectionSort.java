package Algorithm.蓝桥杯;

import Algorithm.SortAlgorithm.SORT;

import java.util.*;

public class collectionSort {
    public static void main(String args[]){
        class T implements Comparable<T>{
            String f; //指标类型
            int real;  //指标值
            int i[];   //数据
            public T(String f,int[] i){
                this.f=f;
                this.i=i;
            }

            @Override
            public int compareTo(T o) {
                if(real>o.real)
                    return 1;
                else if(real<o.real)
                    return -1;
                return 0;
            }
        }
        List<T> list=new ArrayList<>();
        String str=null;
        do{
            Scanner scanner=new Scanner(System.in);
            str=scanner.nextLine();
            if(str.equals("*"))
                break;
            String ss[]=str.split("]");
            String z=ss[0].substring(1);
            String data=ss[1];
            String SeveryData[]=data.split(" ");
            int everydata[]=new int[SeveryData.length];
            for (int i = 0; i < SeveryData.length; i++) {
               everydata[i]=Integer.parseInt(SeveryData[i]);
            }
            T t=new T(z,everydata);
            if(t.f.equals("Max")){
                int max=t.i[0];
                for (int i =0; i < t.i.length; i++) {
                    if(max<t.i[i])
                        max=t.i[i];
                }
                t.real=max;
            }else if(t.f.equals("Min")){
                int min=t.i[0];
                for (int i = 0; i < t.i.length; i++) {
                    if(min>t.i[i])
                        min=t.i[i];
                }
                t.real=min;
            }else if(t.f.equals("Mean")){
                int sum=0;
                for (int i = 0; i < t.i.length; i++) {
                    sum+=t.i[i];
                }
                t.real=sum/t.i.length;
            }else if(t.f.equals("Median")){
                int min=t.i[0];
                for (int i = 0; i < t.i.length; i++) {
                    if(min>t.i[i])
                        min=t.i[i];
                }
                int max=t.i[0];
                for (int i =0; i < t.i.length; i++) {
                    if(max<t.i[i])
                        max=t.i[i];
                }
                t.real=(min+max) / 2;
            }else{
                System.out.println("输入错误");
                break;
            }
            SORT m=new SORT();
            int SortedData[]=m.mergeSort(t.i);
            t.i=SortedData;
            list.add(t);
        }while(true);
        Collections.sort(list);
        for(T t:list){
            System.out.print("{"+t.real+"}");
            for (int x:t.i)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
