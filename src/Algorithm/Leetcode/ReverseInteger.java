package Algorithm.Leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int flag=0;
        if(x<0){
            x=-x;
            flag=1;
        }
        String str=String.valueOf(x);
        char c[]=new char[str.length()];
        for (int i = 0,j=str.length()-1; i <=j; i++,j--) {
            c[i]=str.charAt(j);
            c[j]=str.charAt(i);
        }
        int cut=0;
        for(int i=0;i<c.length;i++){
            cut=i;
            if(c[i]!='0')
                break;
        }
        String str2=new String(c,cut,c.length-cut);
        int fi=0;
        try {
            fi = Integer.parseInt(str2);
        }catch (Exception e){
            fi=0;
        }
        if(flag==1)
            fi=-fi;
        return fi;
    }
    public int reverse2(int x){
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
    public static void main(String args[]){
        ReverseInteger r=new ReverseInteger();
        System.out.println(r.reverse2(2147483647));
    }
}
