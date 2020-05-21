package enumAndGenerics;

public class overClass<T> {
    private T over;
    public T getOver(){
        return over;
    }

    public void setOver(T over) {
        this.over = over;
    }
    public static void main(String args[]){
        overClass<Boolean> over1=new overClass<>();
        overClass<Float> over2=new overClass<>();
        over1.setOver(true);
        over2.setOver(12.3f);
        Boolean b=over1.getOver();
        Float f=over2.getOver();
        System.out.println(b);
        System.out.println(f);
    }
}
