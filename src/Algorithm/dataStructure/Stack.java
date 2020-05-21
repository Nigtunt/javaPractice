package Algorithm.dataStructure;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 15:39
 */
public class Stack extends ArrayList {
    public void push(Object data){
        this.add(data);
    }

    public Object pop(){
        Object o = this.get(this.size() - 1);
        this.remove(this.size() - 1);
        return o;
    }

    public boolean isEmpty(){
        if(this.size() == 0){
            return true;
        }
        return false;
    }
}

