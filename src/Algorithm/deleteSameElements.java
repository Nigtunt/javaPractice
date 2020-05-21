package Algorithm;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2019/11/4 21:50
 */

//删除链表中相同的元素
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class deleteSameElements {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(pHead == null||pHead.next == null) return pHead;
        ListNode temp2 = pHead;
        ListNode temp1 = pHead.next;
        while(temp1!=null){
            if(temp2.val == temp1.val){
                while(temp1!=null&&temp2.val == temp1.val)  temp1=temp1.next;
                ListNode temp = pHead;
                if(temp.val==temp2.val){
                    pHead = temp1;
                }
                else {
                    while(temp.next.val!=temp2.val) temp = temp.next;
                    temp2 = temp;
                }
                temp2.next=temp1;
            }else{
                temp2=temp2.next;
                temp1=temp1.next;}
        }
        return pHead;
    }

    public static void main(String args[]){
        deleteSameElements t = new deleteSameElements();
        ListNode lsit = new ListNode(1);
        lsit.next = new ListNode(0);
        lsit.next.next = new ListNode(2);
        lsit.next.next.next = new ListNode(2);
        lsit.next.next.next.next = new ListNode(3);
        lsit.next.next.next.next.next = new ListNode(3);
        //  lsit.next.next.next.next.next.next = new TreeNode(2);
        ListNode newlist = t.deleteDuplication(lsit);
        System.out.println(200 &240);
    }
}
