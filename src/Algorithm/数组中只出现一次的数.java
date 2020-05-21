package Algorithm;

/**
 * @Author: YHQ
 * @Date: 2019/11/15 16:39
 */
/**
 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，
 最后剩下的就是落单的数，因为成对儿出现的都抵消了。
依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，
表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，
而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，
剩余的两个结果就是这两个只出现一次的数字。
 */
public class 数组中只出现一次的数 {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }            //bitResult得到的结果为1的位是两个只出现一次的数的不同位
        int index = findFirst1(bitResult);   //找到第一个1，也就是第一个不同的位
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){     //这个位是1说明是两个目标之一，其他这个位为1的数可以抵消，这样就找到了一个目标
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
    public static void main(String args[]){
        数组中只出现一次的数 test = new 数组中只出现一次的数();
        int []num1 = new int[1];
        int []num2 = new int [1];
        int array[] = {4,1,2,5,5,1,8,2,7,4};
        test.FindNumsAppearOnce(array,num1,num2);
    }
}
