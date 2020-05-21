package enumAndGenerics;

import java.util.HashMap;
import java.util.Map;

public class MuilOverClass <K,V>{
    public Map<K,V> m=new HashMap<>();
    public void put(K k,V v){
        m.put(k,v);
    }
    public V get(K k){
        return m.get(k);
    }
    public static void main(String args[]){
        MuilOverClass <Integer,String> mu=new MuilOverClass<>();
        for (int i = 0; i < 5; i++) {
            mu.put(i,"集合成员"+i);
        }
        for (int i = 0; i < mu.m.size(); i++) {
            System.out.println(mu.get(i));
        }
    }
}
