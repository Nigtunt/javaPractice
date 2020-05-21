package Algorithm.dataStructure;

/**
 * @Author: YHQ
 * @Date: 2019/11/29 21:09
 */
public class RBTree {
    private Object data;
    private RBTree left;
    private RBTree right;
    private RBTree parent;
    public static Boolean BLACK = false;
    public static Boolean RED = true;
    private boolean color = BLACK;

    public boolean isRedColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RBTree getLeft() {
        return left;
    }

    public void setLeft(RBTree left) {
        this.left = left;
    }

    public RBTree getRight() {
        return right;
    }

    public void setRight(RBTree right) {
        this.right = right;
    }

    public RBTree getParent() {
        return parent;
    }

    public void setParent(RBTree parent) {
        this.parent = parent;
    }

    public RBTree (){}
    public RBTree(Object data) {
        this.data = data;
    }

}
