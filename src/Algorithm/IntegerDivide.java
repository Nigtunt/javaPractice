package Algorithm;

/**
 * @Author: YHQ
 * @Date: 2019/11/6 21:20
 */
public class IntegerDivide {
    int []nums = new int[20];
    int count = 0;
    public void integerDivide(int cur,int sum,int p,int n){
        if(sum > n) return;
        if(sum == n){
            count++;
            System.out.print(n+"=");
            for (int i = 0; i < cur; i++) {
                if (i==cur-1)
                    System.out.print(nums[i]);
                else System.out.print(nums[i]+"+");
            }
            System.out.println();
            return;
        }
        for (int i=p;i>0;i--){
            nums[cur] = i;
            integerDivide(cur+1,sum+i,i,n);
        }
    }
    public static void main(String args[]){
        IntegerDivide i = new IntegerDivide();
        i.integerDivide(0,0,4,4);
        System.out.println(i.count);
    }
}
