### Question
- You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls. 
- You are also given an integer ‘k’ which denotes the number of aggressive cows. 
- You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible. 
- Find the maximum possible minimum distance.

### Sample Input
    stalls= [0 3 4 7 10 9], k=4
    stalls= [4 2 1 3 6], k=2

### Sample Output
    3
    5

### Intuition
- Since we need to maximise the minimum distance between each cow, first we will need to get our search space. Sort the stalls
- Maximum difference in distance between two cows, will be when there are only two cows and we place both of them to the extreme ends which is stalls[n-1]-stalls[0]
- With binary search each time we will get a distance in this range, we will try to allocate this distance between two cows
- each time the distance between two cows exceeds our estimated distance, increase cows
- Now if we couldn't allocate all of our cows a stall, that means our estimated min distance is high, so do high=mid-1 -> as everything on its right will automatically be high
- But if we could allocate all of our cows a stall, that means this might be one of our answer, but to make answer more crisp, do low=mid+1

### Solution
- First, we will sort the given stalls[] array. 
- Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to (stalls[n-1]-stalls[0]). As the ‘stalls[]’ is sorted, ‘stalls[n-1]’ refers to the maximum, and ‘stalls[0]’ is the minimum element. 
- Calculate the ‘mid’.
- Eliminate the halves based on the boolean value returned by canWePlace():
  This function will return true if it is possible to place all the cows with a minimum distance of ‘mid’. 
  - If the returned value is true: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the maximum number. So, we will eliminate the left half and consider the right half(i.e. low = mid+1). 
  - Otherwise, the value mid is greater than the distance we want. This means the numbers greater than ‘mid’ should not be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
- Finally, outside the loop, we will return the value of high as the pointer will be pointing to the answer.

### Code
    public static int aggressiveCows(int[] stalls, int k){
        int n=stalls.length;
        Arrays.sort(stalls);

        int low=1, high= stalls[n-1] - stalls[0];

        while (low<=high){
            int mid= (low+high)/2;
            if (canWePlace(stalls,mid,k,n)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int[] stalls, int dist, int k, int n) {
        int cntCows=1;  //no. of cows placed
        int last= stalls[0];    //position of last placed cow
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist){      //if the current distance >= given distance, add one more cow
                cntCows++;
                last = stalls[i];   //update the position of last cow
            }
            if (cntCows >= k) return true;
        }
        return false;
    }

### Other Techniques
- Instead of Binary Search, we use Linear Search

### Complexity
1. Time Complexity - O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
2. Space Complexity - O(1)