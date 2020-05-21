package Algorithm.dataStructure.Graph;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2019/12/6 14:20
 * 图的临界矩阵
 */
public class MGraph {
    private static final int MAXSIZE = 20;
    Object []vexs = new Object[MAXSIZE];
    ArcCell [][]arcs = new ArcCell[MAXSIZE][MAXSIZE];
    int vexnum = 0,arcnum = 0;
    static class ArcCell{
        int adj;
        public ArcCell(){
            this.adj = 999;
        }
    }
    public void print(){
        for (int i = 0; i < vexnum; i++) {
            for (int i1 = 0; i1 < vexnum; i1++) {
                System.out.print(arcs[i][i1].adj+" ");
            }
            System.out.println();
        }
    }
}
