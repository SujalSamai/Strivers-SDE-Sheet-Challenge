package BinarySearch.BookAllocation;

public class Code {
    public static int findPages(int[]arr,int n,int m) {
        if (m>n) return -1;

        int max=0, sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if (arr[i]>max) max=arr[i];
        }

        int low=max, high=sum, ans=-1;

        while (low<=high){
            int mid = (low+high)/2;
            if(isValid(arr, m, mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean isValid (int []arr, int k, int max){
        int student = 1 ;
        int sum = 0 ;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i] ;
            if(sum > max){
                student ++ ;
                sum = arr[i] ;
            }

            if(student > k){
                return false ;
            }
        }

        return true ;  // student == k
    }
}
