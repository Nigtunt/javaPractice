package ExceptionHandle;

/**
 * @Author: YHQ
 * @Date: 2019/11/27 20:31
 */
public class calculate1 {
    private static Boolean isNumber(String str) {
        for(Integer i = 0 ; i < str.length() ; i++){
            Character c = str.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        try{
            String n1 = args[0];
            String n2 = args[1];
            Integer num1 = Integer.parseInt(n1);
            Integer num2 = Integer.parseInt(n2);
            int count = num1 / num2 ;
            System.out.println(count);

        }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
        }catch (NumberFormatException e1){
            System.out.println(156156);
            System.out.println(e1);
        }catch (ArithmeticException e2){
            System.out.println();
            System.err.println(e2);
        }
    }
}
