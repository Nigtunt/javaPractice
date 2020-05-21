package Algorithm.dataStructure;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 20:52
 */
public class treeList {
    public void create(tree TREE){
        Scanner s= new Scanner(System.in);
        String a = s.next();
        if(a.equals("#")) {
            return;
        }
        else
            TREE.setData(a);
        TREE.setLeft(new tree());
        create(TREE.getLeft());
        TREE.setRight(new tree());
        create(TREE.getRight());
    }
    public void prePrint(tree t){
        if(t==null) return ;
        if (t.getData()!=null)
            System.out.print(t.getData()+" ");
        prePrint(t.getLeft());
        prePrint(t.getRight());
    }
    public void inPrint(tree t){
        if(t==null) return ;
        inPrint(t.getLeft());
        if (t.getData()!=null)
            System.out.print(t.getData()+" ");
        inPrint(t.getRight());
    }
    public void postPrint(tree t){
        if(t==null) return ;
        postPrint(t.getLeft());
        postPrint(t.getRight());
        if (t.getData()!=null)
            System.out.print(t.getData()+" ");
    }
    public void NRPrePrint(tree t){
        Stack<tree> stack = new Stack<>();
        tree temp;
        if(t == null) return ;
        temp = t;
        while(!(temp==null&&stack.empty())){
            while(temp!=null){
                if(temp.getData()!=null)
                    System.out.print(temp.getData()+" ");
                stack.push(temp);
                temp = temp.getLeft();
            }
            if(stack.empty()) return;
            else {
                temp = stack.pop();
                temp = temp.getRight();
            }
        }
    }
    public void NRInPrint(tree t){
        Stack<tree> stack = new Stack<>();
        tree temp;
        if(t == null) return ;
        temp = t;
        while(!(temp==null&&stack.empty())){
            while(temp!=null){

                stack.push(temp);
                temp = temp.getLeft();
            }
            if(stack.empty()) return;
            else {
                temp = stack.pop();
                if(temp.getData()!=null)
                    System.out.print(temp.getData()+" ");
                temp = temp.getRight();

            }
        }
    }
    public void NRPostPrint(tree tree){
        Stack<tree> stack = new Stack<>();
        tree temp;
        if(tree == null) return ;
        temp = tree;
        while(!(temp ==null&&stack.empty())){
            while(temp!=null){
                    stack.push(temp);
                    temp = temp.getLeft();
            }
            if (stack.empty()) return;
            else {
                temp = stack.peek();
                if(temp.getRight()!=null){
                    if(temp.getRight().getData()==null){
                        temp.setRight(null);
                    }
                    temp = temp.getRight();
                }
                else {
                    temp = stack.pop();
                    if(temp.getData()!=null)
                        System.out.print(temp.getData()+" ");
                    temp.setData(null);//此处如果只写temp = null 不能把此子树消除，必须把data设为空然后
                                          //在下一次循环使用setRight()方法
                    temp = null;
                }
            }
        }
    }
    public void levelPrint(tree t){
        if(t == null) return;
        Queue<tree> queue = new LinkedList<>();
        tree temp;
        queue.offer(t);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if (temp.getData()!=null)
                System.out.print(temp.getData()+" ");
            if(temp.getLeft()!=null)
                queue.offer(temp.getLeft());
            if(temp.getRight()!=null)
                queue.offer(temp.getRight());
        }
    }
    public static void main(String args[]){
        treeList treeList = new treeList();
        tree t=new tree();
        treeList.create(t);
        System.out.println("层序遍历：");
        treeList.levelPrint(t);System.out.println();
        System.out.println("树的递归遍历：");
        treeList.prePrint(t);System.out.println("前序");
        treeList.inPrint(t);System.out.println("中序");
        treeList.postPrint(t);System.out.println("后序");
        System.out.println("树的非递归遍历：");
        treeList.NRPrePrint(t);System.out.println("前序");
        treeList.NRInPrint(t);System.out.println("中序");
        treeList.NRPostPrint(t);System.out.println("后序");

    }
}
