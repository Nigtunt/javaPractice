package Algorithm.dataStructure;

import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/11/2 19:18
 */
public class LinkList {
    private Node head = null;
    private int size = 0;
    public void add(Object data){
        Node n = new Node();
        n.setData(data);
        if (this.head == null){
            head = n;
        }else {
            Node temp = head;
            for (int i = 1; i < size; i++) {
                temp = temp.getNext();
            }
            temp.setNext(n);
        }
        this.size++;
    }
    public void del(int index){
        if(index >= size) {
            System.out.println("index过大");
            return;
        }
        if (index == 0 ){
            this.head = this.head.getNext();
        }else {
            Node temp  =this.head;
            for (int i = 0; i <index-1 ; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        this.size--;
    }
    public void update(Object data,int index){
        Node temp  =this.head;
        for (int i = 0; i <index ; i++) {
            temp = temp.getNext();
        }
        temp.setData(data);
    }
    public void insert(Object data,int index){
        if(index >= size){
            System.out.println("没有第" + index + "个元素");
            return;
        }
        Node n = new Node();
        n.setData(data);
        if(index==0){
            n.setNext(head);
            head = n;

        }else{
            Node temp = head;

            for(int i = 1 ; i < index ; i++){
                temp = temp.getNext();
            }
            n.setNext(temp.getNext());
            temp.setNext(n);
        }
        this.size++;
    }
    public Object get(int index){
        if(index >= size) {
            System.out.println("index过大");
            return null;
        }
        Node temp  =this.head;
        for (int i = 0; i <index ; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void sort(){
        Node temp = head;
        for (int i = 1; i < this.getSize(); i++) {
            for (int j = 0;j<this.getSize() - i;j++){
                if((Integer)this.get(j) > (Integer) this.get(j+1)){
                    Integer temp2 =(Integer) this.get(j);
                    this.update(this.get(j+1),j);
                    this.update(temp2,j+1);
                }
            }
        }
    }
    public Node rervse(Node l1){
        Node temp =l1.getNext();
        l1.setNext(null);
        return re(l1,temp);
    }
    public Node re(Node t1,Node t2){
        if (t2 == null) return null;
        Node temp = t2.getNext();
        t2.setNext(t1);
        if (temp == null)
            return t2;
        return re(t2,temp);
    }
    public Node rervse2(Node l1){
        Stack<Object> stack = new Stack<>();
        Node temp = l1;
        while(temp!=null){
            stack.push(temp.getData());
            temp = temp.getNext();
        }
        Node temp2 = l1;
        while (!stack.empty()){
            temp2.setData(stack.pop());
            temp2 = temp2.getNext();
        }
        return l1;
    }
    public void reOrderArray(int [] array) {
        int []temp = new int [array.length];
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 !=0){
                temp[cur++]=array[i];
            }
        }
        int cur2 = cur;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 ==0){
                temp[cur2++]=array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=temp[i];
        }
    }
    public static void main(String args[]){
        LinkList t =new LinkList();
        int []a = new int[]{1,2,3};
        t.reOrderArray(a);
        int temp = 5>6 ? 5:7;
        System.out.println(temp);
    }
}
