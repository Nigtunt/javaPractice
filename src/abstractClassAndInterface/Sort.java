package abstractClassAndInterface;

import java.util.Base64;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: YHQ
 * @Date: 2019/11/9 21:06
 */
public class Sort {

    public void bubble(Comparable[] list){
        for(int j = 0 ; j < list.length - 1 ; j++) {
            for (int i = 0; i < list.length - 1 - j; i++) {

                if(list[i].compareTo(list[i + 1])  == 1){
                    Comparable temp = list[i];
                    list[i] = list[i + 1];
                    list[i+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        employee em1=new employee(1515,"1");
        employee em2 = new employee(2555,"2");
        employee em3 = new employee(1111,"3");
        employee[] ems = {em1,em2,em3};
        Sort sort = new Sort();
        sort.bubble(ems);
        for(employee e:ems){
            System.out.println(e.getSales()+" "+e.getName());
        }
    }
}
