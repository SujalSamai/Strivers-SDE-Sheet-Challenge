package Graphs.FloydWarshall;

public class Code {
    public void shortest_distance(int[][] matrix){
        int n= matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==-1){
                    matrix[i][j]=(int)1e9;
                }
                if (i==j) matrix[i][j]=0;
            }
        }

        for (int k=0; k<n; k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
//        if we need to detect negative edge cycle
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][i]<0){
//                System.out.println("Contains negative edge cycle");
//            }
//        }

        //as described in question, if there is no edge between u & v, return -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==(int)1e9){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
