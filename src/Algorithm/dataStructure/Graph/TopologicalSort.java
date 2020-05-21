package Algorithm.dataStructure.Graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/12/15 17:12
 */
public class TopologicalSort {
    Graph2 G = null;

    public TopologicalSort() {
        G = new Graph2();
    }

    public void topologicalSort(MGraph mGraph,Stack<Integer> stack){
        int num = mGraph.vexnum;
        int degree[] = new int[num];
        for (int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                if (G.mGraph.arcs[i][j].adj!=999)
                    degree[j]++;
            }
        }
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i]==0)
                temp.push(i);
        }
        int curNode,count=0;
        while (!temp.empty()){
            curNode = temp.pop();
            stack.push(curNode);
            count++;
            for (int v = 0;v<mGraph.vexnum;v++){
                if (mGraph.arcs[curNode][v].adj!=999){
                    if (--degree[v]==0) temp.push(v);
                }
            }
        }
        if (count!=mGraph.vexnum)
            throw new RuntimeException("can't be topological sorted");
    }
    private int []visited = null;
    private Stack stack = new Stack();
    public void topological(MGraph mGraph){
        int num = mGraph.vexnum;
        visited = new int[num];
        for (int i=0;i<num;i++){
            if (visited[i]==0)
                if (!dfs(mGraph,i)){
                    System.out.println("存在环");
                    return;
                }
        }
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
    private boolean dfs(MGraph mGraph,int u){
        visited[u] = -1;   //表明正在访问
        for (int i=0;i<mGraph.vexnum;i++){
            if (mGraph.arcs[u][i].adj!=999){
                if (visited[i]==-1)
                    return false;
                else if (visited[i]==0){
                    if (!dfs(mGraph,i))
                        return false;
                }
            }
        }
        visited[u] = 1;
        stack.push(mGraph.vexs[u]);
        return true;
    }

    /**
     * v0 v3 1 v0 v2 1 v0 v4 1 v1 v3 1 v1 v5 1 v2 v6 1 v3 v5 1 v4 v6 1 v5 v7 1  v6 v7 1
     *
     */
    public static void main(String args[]){
        TopologicalSort s = new TopologicalSort();
        s.G.create();
        Stack<Integer> stack = new Stack<>();
        s.topologicalSort(s.G.mGraph,stack);
        Collections.reverse(stack);
        while (!stack.empty()){
            System.out.print(s.G.mGraph.vexs[stack.pop()]+" ");
        }
    }
}
