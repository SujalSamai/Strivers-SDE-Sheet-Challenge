### Question
- You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise). 
- You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

### Sample Input
    matrix = [[1,2,3],[4,5,6],[7,8,9]]
    matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

### Sample Output
    [[7,4,1],[8,5,2],[9,6,3]]
    [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

### Solution
- we will transpose the matrix
- then we can simply reverse each row

### Code
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //transpose the matrix i.e., convert rows into cols & cols into rows
        for(int i=0; i<rows; i++){
            for(int j=i; j<cols; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //reverse each row to get the result
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols/2; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][rows-1-j];
                matrix[i][rows-1-j]= temp;
            }
        }
    }

### Edge Cases
- NA

### Other Techniques
- Using another dummy matrix

### Complexity
1. Time Complexity - O(N*N)
2. Space Complexity - O(1)