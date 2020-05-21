package Algorithm.dataStructure.Graph;

/**
 * @Author: YHQ
 * @Date: 2019/12/7 11:20
 */
public class ShortestPath {
    Graph2 G = null;
    public ShortestPath(){
        G = new Graph2();
        G.create();
    }

    public void Dijkstra(MGraph G,int v0,int p[],int D[]){
        boolean Final[] = new boolean[G.vexnum];
        int min;
        for (int i1 = 0; i1 < G.vexnum; i1++) {
            p[i1] = -1;
        }
        for (int i = 0; i < G.vexnum; i++) {
            Final[i] = false;
            D[i] = G.arcs[v0][i].adj;
            if (D[i]<999) p[i] = v0;
        }
        D[v0] = 0; Final[v0] = true;
        int v = 0;
        for (int i = 1; i < G.vexnum; i++) {

            min = 999;
            for (int w = 0; w < G.vexnum; w++) {   //找到离v0最近的顶点
                if (!Final[w] && D[w] < min){
                    v = w;
                    min = D[w];         //min为v0->v的最短距离
                }
            }

            Final[v] = true;
            for (int w = 0; w < G.vexnum; w++) {    //更新加入v后的最短路径
                if (!Final[w] && (min + G.arcs[v][w].adj < D[w])){
                    D[w] = min + G.arcs[v][w].adj;
                    p[w] = v;                    //更新path
                }
            }

        }

    }

    public void floyd(MGraph G,int p[][],int D[][]){
        for (int v = 0;v<G.vexnum;v++){
            for (int w=0;w<G.vexnum;w++){
                D[v][w] = G.arcs[v][w].adj;
                p[v][w] = -1;
                if (D[v][w]<999){
                    p[v][w] = v;
                }
            }
        }
        for (int u=0;u<G.vexnum;u++)
            for (int v = 0;v<G.vexnum;v++)
                for (int w= 0;w<G.vexnum;w++){
                    if (D[v][u]+D[u][w] < D[v][w]){
                        D[v][w] = D[v][u]+D[u][w];
                        p[v][w] = u;
                    }
                }
    }

    public static void main(String args[]){
        ShortestPath s = new ShortestPath();
        int D[] = new int[s.G.mGraph.vexnum];
        int p[] = new int[s.G.mGraph.vexnum];
        for (int j = 0;j<s.G.mGraph.vexnum;j++){
            s.Dijkstra(s.G.mGraph,j,p,D);
            int sum = 0;
            for(int i=0;i<D.length;i++){
                sum += D[i];
            }
            System.out.println(sum);
        }

//        for (int i=0;i<s.G.mGraph.vexnum;i++){
//            if (D[i]==999) System.out.println(s.G.mGraph.vexs[2]+"->"+s.G.mGraph.vexs[i]+"无");
//            else {
//                findPath(s.G.mGraph,p,i);
//                System.out.println();
//            }
//        }
//        for (int x:p)
//            System.out.print(x+" ");
//        int D[][] = new int[s.G.mGraph.vexnum][s.G.mGraph.vexnum];
//        int p[][] = new int[s.G.mGraph.vexnum][s.G.mGraph.vexnum];
//        s.floyd(s.G.mGraph,p,D);
//        for (int i=0;i<s.G.mGraph.vexnum;i++){
//            System.out.println("顶点"+s.G.mGraph.vexs[i]);
//            for (int j=0;j<s.G.mGraph.vexnum;j++){
//                if (i==j) continue;
//                if (D[i][j]==999) System.out.println(s.G.mGraph.vexs[i]+"->"+s.G.mGraph.vexs[j]+"无");
//                else {
//                    findPath(s.G.mGraph,p[i],j);
//                    System.out.print(D[i][j]);
//                    System.out.println();
//                }
//            }
//        }
    }

    /**
     * v0 v1 v2 v3 v4 v5
     * v0 v2 10 v0 v5 100 v0 v4 30 v1 v2 5 v2 v3 50 v3 v5 10 v4 v3 20 v4 v5 60
     * v1 v2 30 v2 v6 15 v2 v3 20 v3 v6 25 v3 v4 40 v3 v5 60 v4 v6 18 v5 v4 30 v6 v7 15
     * @param p
     * @param v
     */
    private static void findPath(MGraph G,int[] p, int v) {
        if (p[v]==-1){
            System.out.print(G.vexs[v]+"->");
            return;
        }else findPath(G,p,p[v]);
        System.out.print(G.vexs[v]+"->");
    }
}
