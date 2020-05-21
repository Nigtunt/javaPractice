package commonPractice;

public class T_9_11 {
    public char find(char a[]){
        int []count=new int[256];
        for (int i = 0; i < a.length; i++) {
            count[(int)a[i]]++;
        }
        for (int i = 0; i < a.length; i++) {
            if(count[a[i]]==1)
                return a[i];
        }
        return (char)-1;
    }
    public static void main(String arg[]) {
        char a[]={'a','q','a','c','w','w','d'};
        T_9_11 x=new T_9_11();
        char a1=x.find(a);
//        System.out.println(a1);
        int b[]={1,2,3,4,5,6,7,8,9};
        int j=0;
        for (j = 0; j <=8; j++) {
            b[j]=0;
            System.out.println("hello");
        }
    }



}
