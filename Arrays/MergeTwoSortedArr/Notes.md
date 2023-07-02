### Question
- You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. 
- Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
- The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

### Sample Input
    nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    nums1 = [1], m = 1, nums2 = [], n = 0

### Sample Output
    [1,2,2,3,5,6]
    [1]

### Solution
- Take two pointers, one for each array
- traverse till one of the array is traversed completely, check each pointer
- add the element which is small to the resultant arr and increase ptr
- now add all the remaining elements of the array which is not finished yet to out resultant arr
- copy the elements of res arr to first arr

### Code
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

### Edge Cases
- NA

### Other Techniques
- Using Extra Space

### Complexity
1. Time Complexity - O(N+M)
2. Space Complexity - O(M+N)