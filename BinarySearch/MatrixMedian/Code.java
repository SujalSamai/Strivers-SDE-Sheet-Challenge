package BinarySearch.MatrixMedian;

public class Code {
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
}
