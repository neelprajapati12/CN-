public class dvr {
    public static void main(String[] args) {
        int n=4;
        int INF=Integer.MAX_VALUE;
        int[][] graph = {
            {0, 1, 3, INF},
            {1, 0, 1, 4},
            {3, 1, 0, 1},
            {INF, 4, 1, 0}
        };

        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=graph[i][j];
            }
        }


        boolean visited;

        do {
            visited=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(distance[i][k]!=INF && distance[k][j]!=INF && distance[i][j]>distance[i][k]+distance[k][j]){
                            distance[i][j]=distance[i][k]+distance[k][j];
                            visited=true;
                        }
                    }
                }
            }
        } while (visited);

        System.out.println("Final DVR Table is");
        for(int i=0;i<n;i++){
            System.out.println("From Node "+i+" ");
            for(int j=0;j<n;j++){
                if(distance[i][j]==INF){
                    System.out.print("To Node "+i+"INF\t");
                }
                else{
                    System.out.print("To Node "+i+": "+distance[i][j]+"\t");
                }
            }
            System.out.println();
        }

    }
}
