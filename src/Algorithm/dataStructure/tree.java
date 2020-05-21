package Algorithm.dataStructure;


/**
 * @Author: YHQ
 * @Date: 2019/11/3 19:31
 */
public class tree {
    private Object data;
    private tree left;
    private tree right;
    private Integer height = 1;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public tree (){}
    public tree(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public tree getLeft() {
        return left;
    }

    public void setLeft(tree left) {
        this.left = left;
    }

    public tree getRight() {
        return right;
    }

    public void setRight(tree right) {
        this.right = right;
    }
}
