package Algorithm.Leetcode;

import java.util.Scanner;

public class AddTwoNumbers {
    class LNode{
        int data;
        LNode next;
        public LNode(int data) {
            this.data=data;
        }
        public LNode() {
            this.next=null;
        }
    }
    LNode newLink;
    public void create() {
        LNode tempLink1;
        newLink=new LNode();
        tempLink1=newLink;
        Scanner in=new Scanner(System.in);
        tempLink1.next=new LNode(in.nextInt());
        tempLink1=tempLink1.next;
        while(tempLink1.data!=0) {
            tempLink1.next=new LNode(in.nextInt());
            tempLink1=tempLink1.next;
        }
    }
        public void print() {
            LNode p=new LNode();
            p=newLink.next;
            while(p!=null) {
                System.out.print(p.data);
                p=p.next;
            }
        }
        public LNode addTwoNumbers(LNode l1, LNode l2) {   //利用数字加  容易越界 舍弃
            long sum1=0,p=1;
            while(l1!=null){
                sum1=sum1+l1.data*p;
                p*=10;
                l1=l1.next;
            }
            long sum2=0;
            p=1;
            while(l2!=null){
                sum2=sum2+l2.data*p;
                p*=10;
                l2=l2.next;
            }
            long sum=sum1+sum2;
            LNode l3=null;
            LNode temp1,temp2;
            temp2=new LNode((int)sum%10);
            temp1=new LNode(0);
            sum/=10;
            l3=temp2;
            while(sum!=0){
                temp1.next=temp2;
                temp1=temp2;
                temp2=new LNode((int)sum%10);
                sum/=10;
            }
            temp1.next=temp2;
            temp1=temp2;
            return l3;
        }
    public LNode NewAddTwoNumbers(LNode l1, LNode l2){    //改进  直接加  大于十进位
        LNode l3=new LNode(0);
        LNode temp=l3;
        int r=0,flag=0;
        while(l1!=null&&l2!=null){
            int a=l1.data+l2.data+r;
            r=a/10;
            a=a%10;
            temp.next=new LNode(a);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }if(l1!=null){
            while(l1!=null){
                temp.next=new LNode((l1.data+r)%10);
                temp=temp.next;
                r=(l1.data+r)/10;
                l1=l1.next;
            }
        }else if(l2!=null){
            while(l2!=null) {
                temp.next=new LNode((l2.data+r)%10);
                temp=temp.next;
                r=(l2.data+r)/10;
                l2=l2.next;
            }
        }if(r!=0){
            temp.next=new LNode(r);
            temp=temp.next;
        }
        return l3.next;
    }
    public static void main(String[] args) {
            AddTwoNumbers a=new AddTwoNumbers();
            AddTwoNumbers a2=new AddTwoNumbers();
            a.create();
            a2.create();
            LNode a3=a.NewAddTwoNumbers(a.newLink.next, a2.newLink.next);
            //a.print();a2.print();
            LNode p=a3;
            while(p!=null) {
                System.out.print(p.data);
                p=p.next;
            }
        }
    }

