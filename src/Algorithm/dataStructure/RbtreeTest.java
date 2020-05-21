package Algorithm.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @Author: YHQ
 * @Date: 2019/12/1 9:21
 */
public class RbtreeTest {
    public static void main(String args[]){
        RedAndBlackTree rbt = new RedAndBlackTree();
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<100;i++){
            list.add(r.nextInt(10001));
            rbt.insert(list.get(i));
        }
        Collections.shuffle(list);
        for (int i = 0;i<25;i++){
            rbt.remove(list.get(i));
        }
        rbt.inorder(rbt.getRoot());
    }
}
