package Algorithm.Leetcode;

/**
 * @Author: YHQ
 * @Date: 2019/11/28 13:52
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String cur = "1";
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<n;i++){
            int j=0;
            while(j<cur.length()){
                int count = 1;
                    while (j+1<cur.length()&&cur.charAt(j)==cur.charAt(j+1)){
                        count++;
                        j++;
                    }
                    j++;
                sb.append(count+""+cur.charAt(j-1));
            }
            cur = sb.toString();
            sb = new StringBuffer();
        }
        return cur;
    }
    public static void main(String args[]){
        CountAndSay c= new CountAndSay();
        System.out.println(c.countAndSay(28));
    }
}
