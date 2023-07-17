### Question
- You are given a row-wise sorted matrix of size mXn
- Your task is to find the median of the matrix

### Sample Input
    m=5 n=5
    {{1 5 7 9 11}
    {2 3 4 8 9}
    {4 11 14 19 20}
    {6 10 22 99 100}
    {7 15 17 24 28}}

    m=3 n=5
    {1 2 3 4 5}
    {8 9 11 12 13}
    {21 23 25 27 29}}

### Sample Output
    10
    11

### Solution
- We need to make sure that no. of elements to left of median = no. of elements to its right
- So, we choose a middle element in our monotonous search space, and count all the numbers smaller to it from the matrix
- if count is <= half of total elements in matrix, that means this is not median, as our median will have count > half of total elements (_,_,_,6,_,_,_ -> 3 to left, 3 to right (7/2=3), median is 4th index)
- if count > half of total elements in matrix, then we just do high=mid-1 to check if its the smallest number (as that will be the real median)
- if low and high cross each other, just return low

### Code
    public static int findMedian(int[][] matrix, int m, int n) {
        int low=1, high=Integer.MAX_VALUE;
        while (low<=high){
            int mid = (low + high) /2;
            int count=0;
            //count the number of integers lesser than our mid in the given matrix
            for (int i = 0; i < m; i++) {
                count += countSmallerThanMid(matrix[i], mid);
            }
            //we need to make sure no. of elements to left of median = no. of elements to its right

            //if count is lesser or equal to half of total elements in matrix, there must be an
            //element in right side, whose count might be greater than that(which is needed)
            if (count <= (m*n)/2){
                low= mid+1;
            }
            //similarly, if count is > half of total elements, there might be chance that we have a better 
            //answer on left
            else{
                high=mid-1;
            }
        }
        return low;
    }

    private static int countSmallerThanMid(int[] matrix, int mid) {
        //each row is sorted, so just find the first occurrence of mid in the array, and return its index (0 based indexing perks)
        int l=0, h=matrix.length-1;
        while (l<=h){
            int m= (l+h)/2;
            if (matrix[m] <= mid){
                l = m+1;
            }else{
                h= m-1;
            }
        }
        return l;
    } 


### Other Techniques
- Use extra array and add all elements of the matrix to it, sort the array and then return middle value

### Complexity
1. Time Complexity - O(32*MlogN)
2. Space Complexity - O(1)