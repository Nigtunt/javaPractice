package Algorithm.dataStructure.Graph;

import java.util.Arrays;

/**
 * @Author: YHQ
 * @Date: 2019/12/6 15:48
 * 最小生成树  prim and kruskal
 */
public class MinisSpanTree {
    Graph2 G = null;
    public MinisSpanTree(){
        G = new Graph2();
        G.create();
    }
    private int locate(MGraph G,Object v){
        for (int i = 0;i<G.vexnum;i++){
            if (v.equals(G.vexs[i])) return i;
        }
        return -1;
    }
    static class closedge{
        Object vex;
        int lowcost;
    }
    public void Prim(MGraph G, Object u){
        int k = locate(G,u);
        closedge c[] = new closedge[G.vexnum];
        for (int i = 0; i < G.vexnum; i++) {  //初始化
            if (i!=k){
                c[i] = new closedge();
                c[i].vex = u;
                c[i].lowcost = G.arcs[k][i].adj;   //u->编号为i的点的权值
            }
        }
        c[k] = new closedge();
        int min = 0;
        for (int i=1;i<G.vexnum;i++){
            for (int t=0;t<G.vexnum;t++){  //找到一个不为0的给min初始化值
                if (c[t].lowcost!=0){
                    min = c[t].lowcost;
                    k = t;
                    break;
                }
            }

            for (int j=1;j<G.vexnum;j++){
                if (c[j].lowcost!=0&&c[j].lowcost<min){   //找到lowcost最小的
                    min = c[j].lowcost;
                    k = j;
                }
            }

            System.out.println(c[k].vex+"->"+G.vexs[k]);
            c[k].lowcost = 0;       //编号k结点为添加好的结点，不再被选择
            for (int i1 = 0; i1 < G.vexnum; i1++) {  //更新lowcost
                if (G.arcs[k][i1].adj<c[i1].lowcost){
                    c[i1].vex = G.vexs[k];
                    c[i1].lowcost = G.arcs[k][i1].adj;
                }
            }
        }
    }
    static class closedge2 implements Comparable{
        int v1;
        int v2;
        int weiht;

        @Override
        public int compareTo(Object o) {
            if (this.weiht < ((closedge2)o).weiht) return -1;
            else return 0;
        }
    }

    public void kruskal(MGraph G){
        closedge2 c[] = new closedge2[G.arcnum];
        int parent[] = new int[G.vexnum];   //记录当前结点的首节点（用于判断是否产生回路）
        int m = 0;
        for (int i=0;i<G.vexnum;i++){
            for (int j=i+1;j<G.vexnum;j++){
                if (G.arcs[i][j].adj<999){   //记录所有边
                    c[m] = new closedge2();
                    c[m].v1 = i;
                    c[m].v2 = j;
                    c[m].weiht = G.arcs[i][j].adj;
                    m++;
                }
            }
        }
        Arrays.sort(c);    //按照边的权值排序
        for (int i=0;i<G.vexnum;i++) parent[i]=0;
        int Pv1,Pv2;
        for (int i=0;i<G.arcnum;i++){
            Pv1 = find(parent,c[i].v1);
            Pv2 = find(parent,c[i].v2);
            if (Pv1!=Pv2){   //如果不相等说明没有产生回路
                parent[Pv1] = Pv2;   //将一个结点parent指向另一个结点的parent 相当于连成了一个  将两个结点连接起来
                System.out.println(G.vexs[c[i].v1]+"->"+G.vexs[c[i].v2]);

            }
        }

    }
    private int find(int []parent,int f){
        while (parent[f]>0){
            f = parent[f];
        }
        return f;
    }
    public static void main(String args[]){
        MinisSpanTree m = new MinisSpanTree();
        m.kruskal(m.G.mGraph);
    }
}
