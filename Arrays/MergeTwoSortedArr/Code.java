package Arrays.MergeTwoSortedArr;

public class Code {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int arr[] = new int[n+m];
        int i = 0;
        int j=0;
        int k =0;
        while(i<m && j<n){
            if(arr1[i]<= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while(j<n){
            arr[k] = arr2[j];
            j++;
            k++;
        }
        return arr;
    }

    //leetcode
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res= new int[m+n];
        int ptr1=0, ptr2=0;
        int i=0;
        while (ptr1<m && ptr2<n){
            if(nums1[ptr1]<nums2[ptr2]){
                res[i]=nums1[ptr1];
                ptr1++;
            }else{
                res[i]= nums2[ptr2];
                ptr2++;
            }
            i++;
        }

        while(ptr1<m){
            res[i]=nums1[ptr1];
            i++;
            ptr1++;
        }
        while(ptr2<n){
            res[i]=nums2[ptr2];
            i++;
            ptr2++;
        }

        for (int j = 0; j < m+n; j++) {
            nums1[j]=res[j];
        }
    }
}
