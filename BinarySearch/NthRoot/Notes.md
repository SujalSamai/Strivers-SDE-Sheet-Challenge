### Question
- You are given two positive integers 'n' & 'm'
- You have to return the nth root of 'm' i.e., m^(1/n)
- if the nth root is not an integer, return 1

### Sample Input
    n=3 m=27
    n=4 m=69

### Sample Output
    3
    -1

### Solution
- Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to m. 
- Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
  mid = (low+high) // 2 ( ‘//’ refers to integer division)
- Eliminate the halves accordingly:
  - If func(n, m, mid) == 1: On satisfying this condition, we can conclude that the number ‘mid’ is our answer. So, we will return to ‘mid’. 
  - If func(n, m, mid) == 0: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1). 
  - If func(n, m, mid) == 2: the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1). 
- Finally,  if we are outside the loop, this means no answer exists. So, we will return -1.

### Code
    public static int NthRoot(int n, int m) {
        int low=1, high=m;
        while (low<=high){
            int mid= (low+high)/2;
            int midN= func(mid, n, m);
            if (midN==1){
                return mid;
            }else if (midN==0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    private static int func(int mid, int n, int m) {
        long ans=1;
        for (int i = 1; i <= n; i++) {
            ans = ans* mid;
            if (ans>m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }    

### Edge Cases
- After placing low at 1 and high m, we will calculate the value of ‘mid’. 
- Now, based on the value of ‘mid’ raised to the power n, we will check if ‘mid’ can be our answer, and based on this value we will also eliminate the halves. If the value is smaller than m, we will eliminate the left half and if greater we will eliminate the right half. 
- But, if the given numbers m and n are big enough, we cannot store the value midn in a variable. So to resolve this problem, we will implement a function like the following:
func(n, m, mid):
- We will first declare a variable ‘ans’ to store the value midn. 
- Now, we will run a loop for n times to multiply the ‘mid’ n times with ‘ans’. 
- Inside the loop, if at any point ‘ans’ becomes greater than m, we will return 2. 
- Once the loop is completed, if the ‘ans’ is equal to m, we will return 1. 
- If the value is smaller, we will return 0. 
- Now, based on the output of the above function, we will check if ‘mid’ is our possible answer or we will eliminate the halves. Thus we can avoid the integer overflow case.

### Other Techniques
- Linear Search
- Newton- raphson method

### Complexity
1. Time Complexity - O(logN)
2. Space Complexity - O(1)