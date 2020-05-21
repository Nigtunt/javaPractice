package ExceptionHandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2019/11/27 21:02
 */
public class calculate3 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        try {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            if(num2 == 5)
                throw new DivdeFiveException();
            System.out.println(num1/num2);
        } catch (DivdeFiveException e) {
        e.printStackTrace();
        }
    }
}
