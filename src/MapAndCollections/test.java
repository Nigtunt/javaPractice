package MapAndCollections;

import java.util.*;

public class test {

    public static void main(String args[]){
        Map<String,Integer> map = new HashMap<>();
        map.put("aaa",22);
        map.put("bbb",33);
        map.put("ccc",44);
        Iterator itKeys = map.keySet().iterator();
        while(itKeys.hasNext()){
            System.out.print(itKeys.next()+" ");
        }
        System.out.println();
        Iterator itValues = map.values().iterator();
        while(itValues.hasNext()){
            System.out.print(itValues.next()+" ");
        }
        System.out.println();
        Iterator itEntry = map.entrySet().iterator();
        while(itEntry.hasNext()){
            Map.Entry entry = (Map.Entry)itEntry.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
