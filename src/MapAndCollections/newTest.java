package MapAndCollections;


import java.io.File;

/**
 * @Author: YHQ
 * @Date: 2019/11/24 20:03
 */
public class newTest<K,T,V> {
    private K k;
    private T t;
    private V v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
    public static void main(String args[]){
        newTest<String,Integer, File> newTest = new newTest();
        System.out.println(newTest.getK());
}
}
