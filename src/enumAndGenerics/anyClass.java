package enumAndGenerics;

import java.util.*;

public class anyClass {
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        Map<Integer,String> m=new HashMap<>();
        for (int i = 0; i < 5; i++) {
            m.put(i,"成员"+i) ;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(m.get(i));
        }
        Vector<String> v=new Vector<>();
        for (int i = 0; i < 5; i++) {
            v.add("成员"+i);
        }
        Iterator i=v.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

    }
}
