package MuilTread;



public class ThreadTest extends Thread {
    private int count;

    @Override
    public void run() {
        count= 1 ;
        while(true){
            System.out.println(count++);
            if(count>100) break;
        }
    }
    public static void main(String args[]){
        new ThreadTest().start();
    }
}
