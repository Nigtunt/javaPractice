package Algorithm.dataStructure.huffman;

/**
 * @Author: YHQ
 * @Date: 2019/12/14 17:39
 */
public class huffmanTree {
    private huffNode Tree[] = null;
    private String code[] = null;
    private int[] Select(huffNode tree[],int end){
        int ans[] = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < end; i++) {
            if (tree[i].parent!=0) continue;
            if (min>tree[i].weight){
                min = tree[i].weight;
                ans[0] = i;
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 0; i < end; i++) {
            if (tree[i].parent!=0||i==ans[0]) continue;
            if (min>tree[i].weight){
                min = tree[i].weight;
                ans[1] = i;
            }
        }
        return ans;
    }
    public void huffmanCoding(int []w,int n){
        int m = 2 * n - 1 ;
        int s1,s2;
        Tree = new huffNode[m];
        for (int i=0;i<n;i++){     //初始化哈夫曼树
            Tree[i] = new huffNode();
            Tree[i].weight = w[i];
        }
        for (int i = n;i<m;i++){
            Tree[i] = new huffNode();
        }
        for (int i = n ;i<m;i++){
            int ans[] = Select(Tree,i);
            s1 = ans[0];s2 = ans[1];
            Tree[s1].parent=i;Tree[s2].parent=i;
            Tree[i].lchild = s1; Tree[i].rchild = s2;
            Tree[i].weight = Tree[s1].weight + Tree[s2].weight;
        }
        code = new String [n];
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int c = i,f = Tree[i].parent;f!=0;c=f,f=Tree[f].parent){
                if (Tree[f].lchild == c) sb.append(0);
                else sb.append(1);
            }
            code[i] = sb.reverse().toString();
        }
    }
    public void print(int w[]){
        for (int i=0;i<w.length;i++){
            System.out.println(w[i]  +":"+code[i]);
        }
    }
    public static void main(String args[]){
        huffmanTree t = new huffmanTree();
        int w[] = {7,4,56,165,1,5,416};
        t.huffmanCoding(w,w.length);
        t.print(w);
    }
}
