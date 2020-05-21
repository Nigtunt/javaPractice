package Algorithm.dataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2019/12/6 11:13
 */
public class Graph {
    ALGraph alGraph = null;
    boolean visited[] = null;
    private int locate(ALGraph alGraph, String v) {
        for (int i = 0; i < alGraph.vexnum; i++) {
            if (v.equals(alGraph.AdjList.get(i).data)) return i;
        }
        return -1;
    }
    public void create(){
        String t ;
        Scanner s = new Scanner(System.in);
        alGraph = new ALGraph();
        System.out.println("输入顶点");
        do {
            t = s.next();
            if (!t.equals("-1")){
                alGraph.addVNode(t);
            }
        }while (!t.equals("-1"));
        System.out.println("输入边数");
        alGraph.arcnum = s.nextInt();
        System.out.println("输入两边顶点和权值");
        for (int i = 0; i < alGraph.arcnum; i++) {
            String v1=s.next(),v2=s.next();
            int w = s.nextInt();
            int k = locate(alGraph,v1);
            int j = locate(alGraph,v2);
            alGraph.addArc(k,j,w);
        }
        visited = new boolean[alGraph.vexnum];
        s.close();
    }

    /**
     * 广度优先
     * @param G
     */
    public void BFS(ALGraph G){
        int w,u;
        for (int i = 0; i < visited.length; i++) visited[i] = false;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < G.vexnum; i++) {
            if (!visited[i]){
                visited[i] = true;
                System.out.print(G.AdjList.get(i).data+" ");
                queue.offer(i);
                while (!queue.isEmpty()){
                    u = queue.poll();
                    for (w = FirstAdjVex(G,u);w>=0;w=NextAdjVex(G,u)){
                        if (!visited[w]){
                            visited[w] = true;
                            System.out.print(G.AdjList.get(w).data+" ");
                            queue.offer(w);
                        }
                    }

                }
            }
        }
    }
    public void DFSTraverse(ALGraph G){
        for (int i=0;i<G.vexnum;i++) visited[i] = false;
        for (int i = 0; i < G.vexnum; i++) {
            if (!visited[i]) DFS(G,i);
        }
    }
    private void DFS(ALGraph G,int v){
        visited[v] = true;
        System.out.print(G.AdjList.get(v).data+" ");
        for (int w = FirstAdjVex(G,v); w >= 0 ; w = NextAdjVex(G,v))
            if (!visited[w]) DFS(G,w);
    }
    private int FirstAdjVex(ALGraph G,int v){
        if (G.AdjList.get(v).firstnode!=null)
            return G.AdjList.get(v).firstnode.adjvex;
        else return -1;
    }
    private int NextAdjVex(ALGraph G,int v){
        ALGraph.ArcNode p = G.AdjList.get(v).firstnode;
        while (p!=null){
            if (!visited[p.adjvex]) return p.adjvex;
            p = p.nextarc;
        }
        return -1;
    }
    public static void main(String args[]){
        Graph g = new Graph();
        g.create();
        g.alGraph.print();
        g.BFS(g.alGraph);
        System.out.println();
        g.DFSTraverse(g.alGraph);
    }

}