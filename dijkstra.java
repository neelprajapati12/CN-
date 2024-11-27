// import java.util.*;
public class dijkstra {

    public static void main(String[] args) {
        int graph[][] = new int[][] {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source=0;
        Shortestpath s=new Shortestpath();
        s.initialize(source);
        s.dijkstras(graph);
    }
}

class Shortestpath{
    int V=9;
    int INF=Integer.MAX_VALUE;

    int[] distance=new int[V];
    int[] visited=new int[V];

    void initialize(int source){
        for(int i=0;i<V;i++){
            distance[i]=INF;
            visited[i]=0;
        }
        distance[source]=0;
    }

    void print(int[] distance){
        System.out.println("Vertex\tDistance from Source");
        for(int i=0;i<V;i++){
           
            System.out.println("Node "+i+":\t"+distance[i]);
        }
    }

    int findmin(int[] distance){
        int minindex=-1;
        int minval=INF;
        for(int i=0;i<V;i++){
            if(visited[i]==0 && minval>distance[i]){
                minval=distance[i];
                minindex=i;
            }
                
        }
        return minindex;
    }

    void dijkstras(int[][] graph){
        for(int count=0;count<V-1;count++){
            int mindist=findmin(distance);
            if(mindist==-1){
                break;
            }
            visited[mindist]=1;

            for(int i=0;i<V;i++){
                if(visited[i]==0 && graph[mindist][i]!=0 && distance[mindist]!=INF && distance[i]>distance[mindist]+graph[mindist][i]){
                    distance[i]=distance[mindist]+graph[mindist][i];
                }
            }
        }
        print(distance);
    }
}