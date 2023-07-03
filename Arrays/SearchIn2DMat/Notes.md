### Question
- You are given an m x n integer matrix with the following two properties:
  - Each row is sorted in non-decreasing order. 
  - The first integer of each row is greater than the last integer of the previous row. 
- Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

### Sample Input
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13

### Sample Output
    true
    false

### Solution
- We will use Binary Search technique, and traverse the matrix from the last column of the first row
- if we found the target, we will return true
- if the current element < target, increase the row pointer, as the current row can't have the target element
- if the current element > target, decrease the col pointer, as the current col can't have the target element

### Code
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                row++;
                continue;
            }
            if(matrix[row][col]>target){
                col--;
            }
        }
        return false;
    }

### Edge Cases
- NA

### Other Techniques
- Linear Search in the matrix

### Complexity
1. Time Complexity - O(log(m*n))
2. Space Complexity - O(1)