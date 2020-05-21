package Algorithm.dataStructure;

/**
 * @Author: YHQ
 * @Date: 2019/11/2 19:33
 */
public class Node {
    private Object data;//数据域
    private Node next;//指针域

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;

    }
}
