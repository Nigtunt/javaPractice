package Algorithm.dataStructure;


/**
 * @Author: YHQ
 * @Date: 2019/11/29 20:32
 */
public class RedAndBlackTree {
    private RBTree root = null;

    public void insert(Object data){   //node为插入节点
        RBTree node = new RBTree(data);
        RBTree x = this.root;
        RBTree y = null;
        Comparable curNode =null;
        while(x!=null){
            y = x;
            curNode = (Comparable) x.getData();
            if(curNode.compareTo(data)==1)
                x = x.getLeft();
            else 
                x = x.getRight();
        }
        
        node.setParent(y);
        if(y != null){
            Comparable yy = (Comparable) y.getData();
            if(yy.compareTo(data)==1)
                y.setLeft(node);
            else 
                y.setRight(node);
        }else 
            this.root = node;
        node.setColor(RBTree.RED);
        insertFixUp(node);
    }
    /**
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 插入的结点        // 对应《算法导论》中的z
     */
    private void insertFixUp(RBTree node) {
        RBTree parent,gparent;
        parent = parentOf(node);
        while(parent!=null&&parent.isRedColor()){
            gparent = parentOf(parent);
            if(parent == gparent.getLeft()){ //若“父节点”是“祖父节点的左孩子”
                RBTree uncle = gparent.getRight();
                if((uncle!=null)&&uncle.isRedColor()){  //叔叔节点是红色
                    uncle.setColor(RBTree.BLACK);
                    parent.setColor(RBTree.BLACK);
                    gparent.setColor(RBTree.RED);
                    node = gparent;
                    parent = parentOf(node);
                    continue;
                }
                if (parent.getRight() == node){    //叔叔节点是黑色且当前节点是右孩子
                    RBTree temp;
                    left_rotate(parent);
                    temp = parent;
                    parent = node;
                    node = temp;
                }
                parent.setColor(RBTree.BLACK);    //叔叔节点是黑色且当前节点是左孩子
                gparent.setColor(RBTree.RED);
                right_rotate(gparent);
                parent = parentOf(node);
            }else{  //父节点是爷节点的右孩子
                RBTree uncle = gparent.getLeft();
                if((uncle!=null)&&uncle.isRedColor()){  //叔叔节点是红色
                    gparent.setColor(RBTree.RED);
                    uncle.setColor(RBTree.BLACK);
                    parent.setColor(RBTree.BLACK);
                    node = gparent;
                    parent = parentOf(node) ;
                    continue ;
                }
                if (parent.getLeft() == node){    //叔叔节点是黑色且当前节点是左孩子
                    RBTree temp;
                    right_rotate(parent);
                    temp = parent;
                    parent = node;
                    node = temp;
                }
                parent.setColor(RBTree.BLACK);    //叔叔节点是黑色且当前节点是左孩子
                gparent.setColor(RBTree.RED);
                left_rotate(gparent);
                parent = parentOf(node);
            }
        }
        this.root.setColor(RBTree.BLACK);
    }

    public void remove(Object data){
        RBTree x = this.root;
        RBTree node = null;
        while(x!=null){           //找到删除节点
            Comparable curNode = (Comparable) x.getData();
            if(curNode.compareTo(data)==1)
                x=x.getLeft();
            else if(curNode.compareTo(data)==-1)
                x=x.getRight();
            else{
                node = x;
                break;
            }

        }
        if (node == null){
            System.out.println("没有此节点");
            return;
        }

        RBTree child, parent;
        boolean color;
        if(node.getLeft()!=null&&node.getRight()!=null){//找到一个比这个节点大1位的节点
            RBTree replace = node;
            replace = replace.getRight();
            while(replace.getLeft()!=null)    //找到取代节点  ，右子树的最深左子树
                replace = replace.getLeft();

            if (parentOf(node)!=null){     //如果删除节点的父节点位空说明此节点为根节点
                if(parentOf(node).getLeft()==node)
                    parentOf(node).setLeft(replace);
                else
                    parentOf(node).setRight(replace);
            }else
                this.root = replace;

            child = replace.getRight();          //替代节点的右孩子  它一定没有左孩子
            parent = parentOf(replace);          //替代节点的父节点
            color = replace.isRedColor();        //替代节点的颜色
            if(parent==node)     //如果删除节点为替代节点的父节点
                parent=replace;
            else {
                if (child!=null)         //替代节点有孩子  将此孩子挂在替代节点的父节点上
                    child.setParent(parent);
                parent.setLeft(child);
                replace.setRight(node.getRight());  //删除节点的右孩子设为替代节点的右孩子
                node.getRight().setParent(replace);
            }

            replace.setParent(node.getParent());   //替代节点输入删除节点的信息
            replace.setColor(node.isRedColor());
            replace.setLeft(node.getLeft());
            node.getLeft().setParent(replace);   //删除节点的左孩子设为替代节点的左孩子
            if(color == RBTree.BLACK)           //当替代节点的颜色为黑是需要修复
                removeFixUp(child,parent);
            node = null;
            return;
        }
        if (node.getLeft()!=null)       //说明删除节点左右孩子有可能不存在
            child = node.getLeft();
        else
            child = node.getRight();
        parent = node.getParent();
        color = node.isRedColor();
        if(child!=null)                //左右孩子有一个存在
            child.setParent(parent);

        if (parent!=null){
            if (parent.getLeft() == node)
                parent.setLeft(child);
            else
                parent.setRight(child);
        }else
            this.root = child;

        if (color == RBTree.BLACK)         //当删除节点颜色为黑色时需要修复
            removeFixUp(child,parent);
        node = null;
    }

    private void removeFixUp(RBTree child, RBTree parent) {
        RBTree other;
        while((child==null||!child.isRedColor())&&(child!=this.root)){
            if (parent.getLeft() == child){     //child为parent的左孩子
                other = parent.getRight();
                if (other!=null&&other.isRedColor()){  // case1 child的兄弟是红色
                    other.setColor(RBTree.BLACK);
                    parent.setColor(RBTree.RED);
                    left_rotate(parent);
                    other  = parent.getRight();
                }

                if ((other.getLeft()==null||!other.getLeft().isRedColor())
                    &&(other.getRight()==null||!other.getRight().isRedColor())){
                    // case2 child的兄弟是黑色，且兄弟的两个孩子也是黑色
                    other.setColor(RBTree.RED);
                    child = parent;
                    parent = parentOf(child);
                }else {
                    if (other.getRight()==null||!other.getRight().isRedColor()){
                        //case3 child的兄弟是黑色，且兄弟的左孩子是红色，右孩子是黑色
                        other.getLeft().setColor(RBTree.BLACK);
                        other.setColor(RBTree.RED);
                        right_rotate(other);
                        other = parent.getRight();
                    }
                    //case4  x的兄弟是黑色，且兄弟的右孩子是红色，左孩子是任意颜色

                    other.setColor(parent.isRedColor());
                    parent.setColor(RBTree.BLACK);
                    if (other.getRight()!=null)
                        other.getRight().setColor(RBTree.BLACK);
                    left_rotate(parent);
                    child = this.root;
                    break;
                }
            }else {   //child为parent的右孩子
                other = parent.getLeft();
                if (other!=null&&other.isRedColor()){  //case1 child的兄弟是红色的
                    other.setColor(RBTree.BLACK);
                    parent.setColor(RBTree.RED);
                    right_rotate(parent);
                    other = parent.getLeft();
                }
                if ((other.getLeft()==null||!other.getLeft().isRedColor())
                    &&(other.getRight()==null||!other.getRight().isRedColor())){
                    //case2 child的兄弟是黑色的，且兄弟的两个孩子也是黑色的
                    other.setColor(RBTree.RED);
                    child = parent;
                    parent = parentOf(child);
                }else {
                    if (other.getLeft()==null||!other.getLeft().isRedColor()){
                        //case3 child的兄弟是黑色，且兄弟的左孩子为黑色，右孩子为红色
                        other.getRight().setColor(RBTree.BLACK);
                        other.setColor(RBTree.RED);
                        left_rotate(other);
                        other = parent.getLeft();
                    }

                    //case4 x的兄弟是黑色且兄弟的左孩子是红色，右孩子任意
                    other.setColor(parent.isRedColor());
                    parent.setColor(RBTree.BLACK);
                    if (other.getLeft()!=null)
                        other.getLeft().setColor(RBTree.BLACK);
                    right_rotate(parent);
                    child = this.root;
                    break;
                }
            }
        }
        if (child!=null)
            child.setColor(RBTree.BLACK);
    }

    private RBTree parentOf(RBTree node) {
        return node==null? null:node.getParent();
    }

    /**
     *
     * 左旋示意图(对节点x进行左旋)：
     *        px                              px
     *       /                               /
     *      x                               y
     *     /  \      --(左旋)-.           / \                #
     *    lx   y                         x  ry
     *       / \                       /  \
     *     ly   ry                    lx  ly
     */
    public void left_rotate(RBTree x){
        RBTree y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft()!=null){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == null){
            this.root = y;
        }else {
            if (x.getParent().getLeft()==x)
                x.getParent().setLeft(y);
            else
                x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }
    /**
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */

    public void right_rotate(RBTree y){
        RBTree x = y.getLeft();
        y.setLeft(x.getRight());
        if(x.getRight()!=null)
            x.getRight().setParent(y);
        x.setParent(y.getParent());
        if(y.getParent()==null){
            this.root = x;
        }else {
            if(y==y.getParent().getLeft())
                y.getParent().setLeft(x);
            else
                y.getParent().setRight(x);
        }
        x.setRight(y);
        y.setParent(x);
    }
    public void inorder(RBTree node){
        if(node == null) return;
        inorder(node.getLeft());
        System.out.println(node.getData()+":"+node.isRedColor()+":"+(node.getParent()==null?
                null:node.getParent().getData()));
        inorder(node.getRight());
    }
    public RBTree getRoot(){
        return this.root;
    }
    public static void main(String args[]){

    }
}
