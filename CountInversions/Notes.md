### Question
- For a given array of N distinct values, find the total number of inversions that exist i.e., arr[i]>arr[i+1]

### Sample Input
    2 5 1 3 4
    3 2 1

### Sample Output
    4
    3

### Solution
- We will use the standard merge sort approach
- In the merge part, when we merge both divided arrays, wherever we will detect that arr[i]>arr[j], we will add +1 to counter
- The mergeSort() function, divides the array into two parts, and gets the count from each divided part
- merge() function, merges both the array in a sorted fashion, & adds just one extra line to count the pairs

### Code
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

### Edge Cases
- NA

### Other Techniques
- Brute Force - nested loops

### Complexity
1. Time Complexity - O(NlogN)
2. Space Complexity - O(N)