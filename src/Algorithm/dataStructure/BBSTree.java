package Algorithm.dataStructure;


/**
 * @Author: YHQ
 * @Date: 2019/11/16 19:49
 */
public class BBSTree {
    private tree root = null;
    private int size = 0;
    public void add(Object data){
        tree node = new tree(data);
        if(root == null){
            root = node;
        }
        else{
            root = f(this.root,node);
        }
        size++;
    }
    private tree f(tree curNode,tree newNode) {
        Comparable c = (Comparable) curNode.getData();
        Comparable n = (Comparable) newNode.getData();
        if(c.compareTo(n) == -1){
            if(curNode.getRight() != null){
                curNode.setRight(f(curNode.getRight(),newNode));
            }else{
                curNode.setRight(newNode);
            }
        }else if(c.compareTo(n) == 1){
            if(curNode.getLeft() != null){
                curNode.setLeft(f(curNode.getLeft(),newNode));
            }else{
                curNode.setLeft(newNode);
            }
        }else {
            System.out.println("输入错误");
            return null;
        }
        //保证添加了节点，调整节点
        curNode.setHeight(
                Math.max(
                        height(curNode.getLeft()),
                        height(curNode.getRight())
                ) + 1);
        int balance = getBalance(curNode);
        //判断你是什么型 ll rr lr rl
        //ll型
        if(balance > 1 && n.compareTo(curNode.getLeft().getData())==-1)
            return ll_rotate(curNode);
        //rr
        if(balance < -1 && n.compareTo(curNode.getRight().getData())==1)
            return rr_rotate(curNode);
        //lr
        if(balance > 1 && n.compareTo(curNode.getLeft().getData())==1){
            curNode.setLeft(rr_rotate(curNode.getLeft()));
            return ll_rotate(curNode);
        }
        //rl
        if(balance < -1 && n.compareTo(curNode.getRight().getData())==-1){
            curNode.setRight(ll_rotate(curNode.getLeft()));
            return rr_rotate(curNode);
        }
        return curNode;
    }
    public tree ll_rotate(tree y){
        tree x = y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);

        y.setHeight(Math.max(
                height(y.getLeft()),
                height(y.getRight())) + 1);

        x.setHeight(Math.max(
                height(x.getLeft()),
                height(x.getRight())) + 1);
        return x;
    }

    /**
     * rr旋转
     * @param y
     * @return tree
     */
    public tree rr_rotate(tree y){
        tree x = y.getRight();
        y.setRight(x.getLeft());
        x.setLeft(y);
        y.setHeight(Math.max(
                height(y.getLeft()),
                height(y.getRight())) + 1);

        x.setHeight(Math.max(
                height(x.getLeft()),
                height(x.getRight())) + 1);
        return x;
    }

    /**
     * lr旋转
     * @param y
     * @return
     */
    public tree lr_rotate(tree y){
        tree x = y.getLeft();
        y.setLeft(rr_rotate(x));
        tree t = ll_rotate(y);
        return t;
    }

    /**
     * rl旋转
     * @param y
     * @return
     */
    public tree rl_rotate(tree y){
        tree x = y.getLeft();
        y.setRight(ll_rotate(x));
        tree t = rr_rotate(y);
        return t;
    }

    private int height(tree node){
        if(node == null){
            return 0;
        }
        return node.getHeight();
    }

    /**
     * 平衡因子 实际就是左树高和右树高的差
     * @param node
     * @return
     */
    public int getBalance(tree node){
        if(node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
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
        if(comparable.compareTo(data) > 0)
            root.setLeft(deleteNode(root.getLeft(),data));
        else if(comparable.compareTo(data) < 0)
            root.setRight(deleteNode(root.getRight(),data));
        else{
            if(root.getLeft()==null||root.getRight()==null){
                tree temp = root.getLeft()!=null ? root.getLeft():root.getRight();
                if(temp == null){
                    temp = root;
                    root = null;
                }else{
                    root = temp;
                    temp =null;
                }
            }else{
                tree temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNode(root.getRight(),temp.getData()));
            }
        }
        if(root == null)
            return null;
        root.setHeight(
                Math.max(
                        height(root.getLeft()),
                        height(root.getRight())
                ) + 1);
        int balance = getBalance(root);
        //ll型
        if(balance > 1 && getBalance(root.getLeft())>=0)
            return ll_rotate(root);
        //rr
        if(balance < -1 && getBalance(root.getRight())<=0)
            return rr_rotate(root);
        //lr
        if(balance > 1 && getBalance(root.getLeft())<0){
            root.setLeft(rr_rotate(root.getLeft()));
            return ll_rotate(root);
        }
        //rl
        if(balance < -1 && getBalance(root.getRight())>0){
            root.setRight(rr_rotate(root.getRight()));
            return rr_rotate(root);
        }

        return root;
    }
    public void remove(Object data){
        this.root = deleteNode(this.root,data);
        if(size>0)
            size--;
    }
    public int size(){
        return this.size;
    }

    public static void main(String args[]){
        BBSTree b = new BBSTree();
        for (int i = 1; i < 80; i++) {
            b.add(i);
            System.out.println(b.getBalance(b.root));

        }
        b.remove(4);
        System.out.println(b.getBalance(b.root));
    }
}
