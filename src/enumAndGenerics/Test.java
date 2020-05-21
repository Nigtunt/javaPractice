package enumAndGenerics;


class pet{
    void say(){
        System.out.println("pet.say");
    }

}
public class Test extends pet{
    private Object b;
    public void setB(Object b){
        this.b=b;

    }
    public Object getB(){
        return b;
    }
    public static void main(String args[]){

        Test t=new Test();
        t.setB(5);
        Test t2=t;
        int a=5;
        System.out.println(t.getB());
        System.out.println(t2.getB());

    }
}
