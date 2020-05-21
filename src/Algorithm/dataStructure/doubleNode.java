package Algorithm.dataStructure;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 14:06
 */
public class doubleNode {
    private Object data;
    private doubleNode next;
    private doubleNode pre;
    public void setNext(doubleNode next){
        this.next=next;
    }
    public void setPre(doubleNode pre){
        this.pre = pre;
    }
    public void setData(Object data){
        this.data = data;
    }
    public Object getData(){
        return this.data;
    }
    public doubleNode getNext(){
        return this.next;
    }
    public doubleNode getPre(){
        return this.pre;
    }
}
