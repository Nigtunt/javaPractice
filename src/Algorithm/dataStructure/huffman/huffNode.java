package Algorithm.dataStructure.huffman;

/**
 * @Author: YHQ
 * @Date: 2019/12/14 17:38
 */
public class huffNode {
    int weight;
    int parent,lchild,rchild;

    public huffNode() {
        weight = 0;parent = 0;
        lchild = 0; rchild = 0;
    }
}
