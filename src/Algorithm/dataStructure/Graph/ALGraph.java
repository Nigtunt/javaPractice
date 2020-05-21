package Algorithm.dataStructure.Graph;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2019/12/6 11:05
 * 图的邻接表
 */
public class ALGraph {
    ArrayList<VNode> AdjList= new ArrayList<>();
    int vexnum = 0, arcnum = 0;

    public void addArc(int k,int j,int w) {
        ArcNode p = new ArcNode();
        p.adjvex = j;
        p.weight = w;
        p.nextarc = this.AdjList.get(k).firstnode;
        this.AdjList.get(k).firstnode = p;
    }

    class ArcNode{ //表结点
        int adjvex; //邻接边在表中的位置
        int weight;
        char tag;
        ArcNode nextarc ;
    }
    class VNode{  //头结点
        Object data;

        public VNode(Object data, ArcNode firstnode) {
            this.data = data;
            this.firstnode = firstnode;
        }

        ArcNode firstnode ;
    }
    public void addVNode(Object data){
        AdjList.add(new VNode(data,null));
        this.vexnum++;
    }
    public void print(){
        for (int i=0;i<this.vexnum;i++){
            VNode head = this.AdjList.get(i);
            ArcNode p = head.firstnode;
            System.out.print(head.data);
            while (p!=null){
                System.out.print("->"+p.adjvex);
                p=p.nextarc;
            }
            System.out.println();
        }
    }
}
