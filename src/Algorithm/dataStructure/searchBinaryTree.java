package Algorithm.dataStructure;

import abstractClassAndInterface.employee;

import java.util.Collections;

/**
 * @Author: YHQ
 * @Date: 2019/11/10 9:27
 */
public class searchBinaryTree {
    private tree root = null ;
    private int size = 0;
    public void add (Object data){
        tree t = new tree(data);
        if(root == null){
            root = t;
        }else {
            tree temp = root;
            while(temp!=null){
                Comparable comparable =(Comparable)temp.getData();
                if(comparable.compareTo(data)==1){
                    if(temp.getLeft()!=null)
                        temp = temp.getLeft();
                    else {
                        temp.setLeft(t);
                        break;
                    }
                }
                else {
                    if (temp.getRight() != null)
                        temp = temp.getRight();
                    else {
                        temp.setRight(t);
                        break;
                    }
                }
            }
        }
        this.size++;
    }
    public void diguiAdd(Object data){
        boolean flag = false;
        tree node = new tree(data);
        if(root == null){
            root = node;
        }
        else{
            flag = f(this.root,node);
        }
        if(!flag)
            this.size++;
    }

    private boolean f(tree currentNode,tree newNode){
        Comparable c = (Comparable) currentNode.getData();
        Comparable n = (Comparable) newNode.getData();
        if(c.compareTo(n) == -1){
            if(currentNode.getRight() != null){
                f(currentNode.getRight(),newNode);
            }else{
                currentNode.setRight(newNode);
            }
        }else if(c.compareTo(n) == 1){
            if(currentNode.getLeft() != null){
                f(currentNode.getLeft(),newNode);
            }else{
                currentNode.setLeft(newNode);
            }
        }else {
            return true;
        }

        return false;
    }
    public Object get(Object data){
        if(root == null){
            return null;
        }else {
            tree temp = root;
            while(temp!=null){
                Comparable comparable =(Comparable)temp.getData();
                if(comparable.compareTo(data)==1){
                    if(temp.getLeft()!=null)
                        temp = temp.getLeft();
                    else {
                        return null;
                    }
                }
                else if(comparable.compareTo(data)==-1){
                    if (temp.getRight() != null)
                        temp = temp.getRight();
                    else {
                        return null;
                    }
                }else{
                    if(data.equals(temp.getData()))   // data需要重写equals方法
                        return temp.getData();
                    else return null;
                }

            }
        }
        return null;
    }
    public tree minValueNode(tree Node){
        tree cur = Node;
        while(cur.getLeft()!=null){
            cur = cur.getLeft();
        }
        return cur;
    }
    public tree deleteNode(tree root , Object data){
        if(root == null) return null;
        Comparable comparable = (Comparable) root.getData();
        if(comparable.compareTo(data)==1)
            root.setLeft(deleteNode(root.getLeft(),data));
        else if(comparable.compareTo(data)==-1)
            root.setRight(deleteNode(root.getRight(),data));
        else{
            if(root.getLeft()==null||root.getRight()==null){
                tree temp = root.getLeft()!=null ? root.getLeft():root.getRight();
                if(temp == null){
                    temp = root;
                    root = null;
                }else{
                    root = temp;
                    //temp =null;
                }
            }else{
                tree temp = minValueNode(root.getRight()); //寻找替代结点
                root.setData(temp.getData());  //顶替需要删除的结点
                root.setRight(deleteNode(root.getRight(),temp.getData()));  //删除顶替结点
            }
        }
        if(root == null)
            return root;
        return root;
    }
    public void remove(Object data){
        this.root = deleteNode(this.root,data);
        if(size>0)
            size--;
    }
    public void inOrder(tree root){
        if(root == null) return;
        inOrder(root.getLeft());
        System.out.print(root.getData()+" ");
        inOrder(root.getRight());

    }
    public static void main(String args[]){
        searchBinaryTree BSTree = new searchBinaryTree();
        BSTree.add(10);
        BSTree.add(13);
        BSTree.add(12);
        BSTree.add(1);
        BSTree.add(6);
        BSTree.add(9);
        BSTree.add(11);
        BSTree.add(15);
        BSTree.inOrder(BSTree.root);
        BSTree.remove(9);
        BSTree.remove(10);
        BSTree.remove(1);
        System.out.println();
        BSTree.inOrder(BSTree.root);
    }
}
