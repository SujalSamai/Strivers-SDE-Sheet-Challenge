### Question
- You have N books, each with Ai number of pages. 
- M students need to be allocated contiguous books, with each student getting at least one book. 
- Out of all the permutations, the goal is to find the permutation where the student with the most pages allocated to him gets the minimum number of pages, out of all possible permutations. 
- Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.

### Sample Input
    N = 4, A[] = {12,34,67,90}, M = 2
    N = 3, A[] = {15,17,20}, M = 2

### Sample Output
    113
    32

### Intuition
- Since each student will atleast get one whole book, then we can say that one of them will atleast get the book which has maximum pages
- Suppose there is only one student, and there are 5 books, then all 5 books will be given to the one student
- So these two are our bounds or our search space
- We will each time through binary search, will determine certain no. of pages, and check if we allocate till this many pages to a student, how many students will get the books
- if the students are more than the intended, we can say, we need to increase the number of pages allocated to students

### Solution
- If m > n: In this case, book allocation is not possible and so, we will return -1. 
- Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to max(arr[]) and the high will point to sum(arr[]).
- Eliminate the halves based number of students are exactly what is given or not through our partition:
  - each time sum of pages allocated to a student is greater than max, we will increase student count, and our sum will again start from current student
  - if number of students exceed k, means this is wrong way of partition
- Now if our halves are valid, then mid is one of the possible answers. But we want the minimum value. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
- else, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
- finally outside loop, return answer

### Code
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
                student++;
                sum = arr[i];
            }
            if(student > k){
                return false ;
            }
        }
        return true ;  // student == k
    }

### Other Techniques
- Instead of Binary Search, we use Linear Search

### Complexity
1. Time Complexity - O(N * log(sum(arr[])-max(arr[])+1))
2. Space Complexity - O(1)