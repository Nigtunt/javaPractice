package Algorithm.dataStructure.Graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/12/17 19:12
 */
public class CriticalPath {
    Graph G = null;
    public CriticalPath(){
        G = new Graph();
    }
    public void FindInDegree(ALGraph G,int indegree[]){
        Arrays.fill(indegree,0);
        ALGraph.ArcNode p;
        for (int i = 0; i < G.vexnum; i++) {
            p = G.AdjList.get(i).firstnode;
            for (;p!=null;p = p.nextarc){
                indegree[p.adjvex]++;
            }
        }
    }
    public boolean TopologicalOrder(ALGraph G, Stack<Integer> T,int[] ve){
        int indegree[] = new int[G.vexnum];
        int count = 0,curNode;
        ALGraph.ArcNode p;
        Arrays.fill(ve,0);
        Stack<Integer> S = new Stack<>();
        FindInDegree(G,indegree);
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i]==0)
                S.push(i);
        }
        while (!S.empty()){
            curNode = S.pop();
            T.push(curNode);
            count++;
            for (p=G.AdjList.get(curNode).firstnode;p!=null;p = p.nextarc){
                int nextNode = p.adjvex;
                if (--indegree[nextNode]==0) S.push(nextNode);
                if (ve[curNode]+p.weight>ve[nextNode])
                    ve[nextNode] = ve[curNode] + p.weight;
            }
        }
        return count==G.vexnum;
    }
    public void criticalPath(ALGraph G){
        ALGraph.ArcNode p;
        int curNode,nextNode;
        int vl[] = new int[G.vexnum]; //顶点最迟发生时间
        int ve[] = new int[G.vexnum]; //顶点最早发生时间
        Stack<Integer> T = new Stack<>();  //逆拓扑排序

        if (!TopologicalOrder(G,T,ve)) throw new RuntimeException("can't topological");
        int tail = T.peek();
        int max = 0;
        for (int i=0;i<ve.length;i++)
            max = Math.max(ve[i],max);
        for (int i = 0; i < G.vexnum; i++) {
            vl[i] = max;
        }
        int dut,ee,el;  //ee边的最早发生时间
        int head = 0;
        while (!T.empty()){
            for (curNode=T.pop(),p=G.AdjList.get(curNode).firstnode;p!=null;p = p.nextarc){
                nextNode = p.adjvex; dut = p.weight;
                if (vl[nextNode]-dut<vl[curNode])
                    vl[curNode] = vl[nextNode]-dut;
                head = curNode;
            }
        }
        for (curNode=0;curNode<G.vexnum;curNode++){
            for (p=G.AdjList.get(curNode).firstnode;p!=null;p=p.nextarc){
                nextNode = p.adjvex; dut = p.weight;
                ee = ve[curNode]; el = vl[nextNode] - dut;
                p.tag = (ee==el)? '*':' ';
                System.out.printf("%s  %s  %d  %d  %d  %c\n",G.AdjList.get(curNode).data,G.AdjList.get(nextNode).data,dut,ee,el,p.tag);
            }
        }
        System.out.println("head:"+head+" tail:"+tail);
        int E[] = new int [10];
        int cur = 0;
        E[cur] = head;
        for (p=G.AdjList.get(head).firstnode;p!=null;p = p.nextarc){
            if (p.tag=='*'){
                E[1+cur] = p.adjvex;
                dfs(G,p.adjvex,tail,E,cur+1);
            }
        }
    }
    public void dfs(ALGraph G,int next,int tail,int E[],int cur){
        if (next == tail){
            for (int i=0;i<=cur;i++){
                System.out.print(G.AdjList.get(E[i]).data);
                if (i!=cur)
                    System.out.print("->");
            }
            System.out.println();
            return;
        }
        ALGraph.ArcNode p;
        for (p=G.AdjList.get(next).firstnode;p!=null;p = p.nextarc){
            if (p.tag=='*'){
                E[1+cur] = p.adjvex;
                dfs(G,p.adjvex,tail,E,cur+1);
            }
        }
    }

    /**
     * v1 v2 v3 v4 v5 v6 v7 v8 v9 -1
     * v1 v2 6 v1 v3 4 v2 v5 1 v3 v5 1 v1 v4 5 v4 v6 2 v5 v7 9 v5 v8 7 v6 v8 4 v7 v9 2 v8 v9 4
     * v1 v2 6 v1 v3 4 v2 v5 1 v3 v5 1 v1 v4 5 v4 v6 2 v5 v7 9 v5 v8 7 v6 v8 4 v7 v9 2 v8 v9 4 v1 v10 7 v10 v11 3 v11 v9 8
     * v1 v2 1 v1 v6 1 v1 v8 1 v2 v3 1 v6 v3 1 v8 v3 1 v3 v4 1 v3 v7 1 v3 v9 1 v4 v5 1 v7 v5 1 v9 v5 1
     * @param args
     */
    public static void main(String args[]){
        CriticalPath c = new CriticalPath();
        c.G.create();
        c.criticalPath(c.G.alGraph);
    }
}
