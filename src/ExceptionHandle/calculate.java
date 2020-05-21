package ExceptionHandle;

/**
 * @Author: YHQ
 * @Date: 2019/11/27 19:58
 */
public class calculate {
    private static Boolean isNumber(String str){
        for(Integer i = 0 ; i < str.length() ; i++){
            Character c = str.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    // java edu.xalead.Caulate  20 30
    public static void main(String[] args) {
        if(args != null && args.length >= 2) {
            String n1 = args[0];
            String n2 = args[1];
            if(isNumber(n1) && isNumber(n2)) {
                Integer num1 = Integer.parseInt(n1);
                Integer num2 = Integer.parseInt(n2);
                if(num2 != 0) {
                    Integer result = num1 / num2;
                    System.out.println(result);
                }else{
                    System.err.println("除数不能为零");
                }
            }else{
                System.err.println("必须两个字符串都是数字字符串");
            }
        }else{
            System.err.println("必须两个以上命令行参数");
        }
    }

}
