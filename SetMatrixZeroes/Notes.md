### Question
- Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
- You must do it in place.

### Sample Input
    [[1,1,1],[1,0,1],[1,1,1]]
    [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

### Sample Output
    [[1,0,1],[0,0,0],[1,0,1]]
    [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

### Solution
- We will use the first row, & first col to mark which row/col has 0, note that mat[0][0] is both in first row & first col, so handle it using different variable col0
- col0 will check if the first col has 0, then mark mat[0][0]=0
- rest we will check every row & col element, & if they are 0, then mark both first rows & cols as 0
- traverse matrix from end, if the first row/col has 0, mark the element as 0
- also if col0 is 0, then entire first col should be 0
### Code
     public static void setZeros(int matrix[][]) {
        int col0=1, rows=matrix.length, cols=matrix[0].length;
        for(int i=0; i<rows; i++){
            if(matrix[i][0]==0){
                col0=0;
            }
            for(int j=1; j<cols; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=1; j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col0==0){
                matrix[i][0]=0;
            }
        }
    }

### Edge Cases
- NA

### Other Techniques
- using two dummy arrays & keeping check which row/col has 0s

### Complexity
1. Time Complexity - O(2*(NM))
2. Space Complexity - O(1)