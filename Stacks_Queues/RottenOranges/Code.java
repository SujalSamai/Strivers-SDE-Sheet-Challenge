package Stacks_Queues.RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Code {
    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q= new LinkedList<>();

        //find out the initial rotten oranges & store in queue, and count the fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2) q.offer(new int[]{i,j});
                else if(grid[i][j]==1) fresh++;
            }
        }

        int count=0;    //counts the time
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}}; //defining the four directions
        while (!q.isEmpty() && fresh!=0){
            count++;
            int sz= q.size();   //make sure to initialise it as size of queue keeps on changing
            for (int i=0; i<sz; i++){     //for each rotten orange
                int[] rotten=q.poll();
                int r=rotten[0], c=rotten[1];   //getting the indexes of rotten orange
                for (int[] dir : directions) {  //for each direction, check if a fresh orange is present
                    int x= r+dir[0];
                    int y= c+dir[1];

                    if (x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                        grid[x][y]=2;       //if present make it rotten & add to queue
                        q.offer(new int[]{x,y});
                        fresh--;
                    }
                }
            }
        }

        return fresh==0 ? count : -1;   //if after bfs traversal, we still have fresh orange then we can't reach it, return -1
    }
}
