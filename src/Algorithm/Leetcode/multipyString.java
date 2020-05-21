package Algorithm.Leetcode;

/**
 * @Author: YHQ
 * @Date: 2019/12/10 16:43
 */
public class multipyString {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
    public String multiply2(String num1, String num2) {
        String sum = "0";
        StringBuilder sb1 ;
        StringBuilder sb2 = new StringBuilder();
        for (int i = num1.length()-1;i>=0;i--){
            sb1 = new StringBuilder();
            for (int j=num2.length()-1;j>=0;j--){
                String a = String.valueOf((num1.charAt(i)-'0')*(num2.charAt(j)-'0'))+sb1.toString()+sb2.toString();
                sum = add(sum,a);
                sb1.append("0");
            }
            sb2.append("0");
        }
        return sum;
    }
    private String add(String num1,String num2){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}
