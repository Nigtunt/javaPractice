package Algorithm.dataStructure;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 19:17
 */
public class Queue extends LinkList{
    public boolean isEmpty(){
        if(this.getSize() == 0){
            return true;
        }
        return false;
    }

    public void offer(Object obj){
        this.add(obj);
    }

    public Object poll(){
        if(!isEmpty()){
            Object o  = this.get(0);
            this.del(0);
            return o;
        }
        return null;
    }

}
