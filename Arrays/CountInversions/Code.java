package Arrays.CountInversions;

public class Code {
    public static void main(String[] args) {
        long[] arr={2,5,1,3,4};
        System.out.println(getInversions(arr, arr.length));
    }

    //Brute force
//    public static long getInversions(long arr[], int n) {
//        int count=0;
//        for(int i=0; i<n-1; i++){
//            for (int j = i+1; j < n; j++) {
//                if(arr[j]<arr[i]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    //using merge sort - O(nlogn) & O(N)
    public static long getInversions(long[] arr, int n){
        return mergeSort(arr, 0, n-1);
    }

    private static long mergeSort(long[] arr, int left, int right) {
        long invCount=0;
        if(right>left){
            int mid=(left+right)/2;
            invCount+= mergeSort(arr,left,mid);
            invCount+= mergeSort(arr, mid+1, right);

            invCount+=merge(arr,left, mid+1, right);
        }
        return invCount;
    }

    private static long merge(long[] arr, int left, int mid, int right) {
        int i= left, j=mid, k=0;
        long invCount=0;
        long[] temp=new long[(right-left+1)];

        while ((i<mid) && (j<=right)){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                ++k;
                ++i;
            }else{
                temp[k]=arr[j];
                invCount += mid-i;  //only step different from merge sort, when we found a pair increase the count
                ++k;
                ++j;
            }
        }

        while (i<mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while (j<=right){
            temp[k]=arr[j];
            k++;
            j++;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }
}
