package Algorithm.Leetcode;

import org.junit.Test;

/**
 * @Author: YHQ
 * @Date: 2020/2/22 12:33
 */
public class 链表排序 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        ListNode temp = new ListNode(0);
        ListNode r = temp;
        while(left!=null&&right!=null){
            if(left.val>right.val){
                temp.next = right;
                right = right.next;
            }else{
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        temp.next = left != null ? left : right;
        return r.next;
    }
    @Test
    public void test(){
        ListNode head = new ListNode(5);
        head.next = new ListNode(8);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(10);

        ListNode temp = sortList(head);
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
