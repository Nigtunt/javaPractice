package Algorithm.dataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2019/12/6 14:41
 */
public class Graph2 {
    MGraph mGraph = null;
    boolean visited[] = null;

    private int LocateVex(MGraph G,String v){
        for (int i=0;i<G.vexnum;i++){
            if (v.equals(G.vexs[i])) return i;
        }
        return -1;
    }

    public void create(){
        mGraph = new MGraph();
        String t ;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < mGraph.arcs.length; i++) {
            for (int i1 = 0; i1 < mGraph.arcs[i].length; i1++) {
                mGraph.arcs[i][i1] = new MGraph.ArcCell();
            }
        }

        System.out.println("输入顶点数和边数");
        mGraph.vexnum = s.nextInt();
        mGraph.arcnum = s.nextInt();
        System.out.println("输入顶点");
        for (int i = 0; i < mGraph.vexnum; i++) {
            mGraph.vexs[i] = s.next();
        }
        System.out.println("输入顶点 和权值");
        for (int i = 0; i < mGraph.arcnum;i++){
            int weight;
            String v1,v2;
            v1 = s.next(); v2 = s.next();
            weight = s.nextInt();
            int m = LocateVex(mGraph,v1);
            int n = LocateVex(mGraph,v2);
            mGraph.arcs[m][n].adj = weight;   //无向图
            mGraph.arcs[n][m].adj = weight;  //有向图
        }
        visited = new boolean[mGraph.vexnum];
    }

    private int FirstAdjVex(MGraph G,int v){
        for (int i = 0; i < G.vexnum; i++) {
            if (G.arcs[v][i].adj!=0) return i;
        }
        return -1;
    }

    private int NextAdjVex(MGraph G,int v,int w){
        for (int i = w+1; i < G.vexnum; i++) {
            if (G.arcs[v][i].adj!=0) return i;
        }
        return -1;
    }

    public void DFSTraverse(MGraph G){
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < G.vexnum; i++) {
            if (!visited[i]) DFS(G,i);
        }
    }
    private void DFS(MGraph G,int v){
        visited[v] = true;
        System.out.print(G.vexs[v]+" ");
        for (int w = FirstAdjVex(G,v);w>=0;w = NextAdjVex(G,v,w)){
            if (!visited[w]) DFS(G,w);
        }
    }

    public void BFSTraverse(MGraph G){
        for (int i = 0; i < G.vexnum; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < G.vexnum; i++) {
            if (!visited[i]){
                visited[i] = true;
                System.out.print(G.vexs[i]+" ");
                queue.offer(i);
                while (!queue.isEmpty()){
                    int u = queue.poll();
                    for (int w = FirstAdjVex(G,u);w>=0;w = NextAdjVex(G,u,w)){
                        if (!visited[w]) {
                            visited[w] = true;
                            System.out.print(G.vexs[w]+" ");
                            queue.offer(w);
                        }
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        Graph2 g = new Graph2();
        g.create();
        g.mGraph.print();
        g.BFSTraverse(g.mGraph);
        g.DFSTraverse(g.mGraph);
    }
}
