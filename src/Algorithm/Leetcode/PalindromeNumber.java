package Algorithm.Leetcode;

public class PalindromeNumber {
    public boolean isPalindrome0(int x){
        int ans = 0,temp=x;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return false;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return false;
            ans = ans * 10 + pop;
            x /= 10;
        }
        if(temp==ans) return true;
        return false;
    }
    public boolean isPalindrome(int x) {
        if(x<0|| (x % 10 == 0 && x != 0)) return false;
        int ans = 0;
        while (x > ans) {
            int pop = x % 10;
            ans = ans * 10 + pop;
            x /= 10;
        }
        if(ans/10==x||ans==x) return true;
        return false;
    }

    public static void main(String args[]){
        PalindromeNumber p=new PalindromeNumber();
        System.out.println(p.isPalindrome0(123321));
    }
}
