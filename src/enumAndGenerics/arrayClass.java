package enumAndGenerics;

public class arrayClass<T> {
    private T[] array;

    public void SetT(T[] array){
        this.array=array;
    }

    public T[] getT() {
        return array;
    }
    public static void main(String args[]){
        arrayClass<String>  a=new arrayClass<>();
        String[] array={"成员1","成员2","成员3","成员4","成员5","成员6",};
        a.SetT(array);
        for (int i = 0; i < a.getT().length; i++) {
            System.out.println(a.getT()[i]);
        }
    }
}
