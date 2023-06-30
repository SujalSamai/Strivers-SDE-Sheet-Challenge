### Question
- Given an array nums of size n, return the majority element. 
- The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

### Sample Input
    [3,2,3]
    [2,2,1,1,1,2,2]

### Sample Output
    3
    2

### Solution
- We traverse the array, if count=0, set the current element as candidate
- If next element == candidate, count++, else count--
- the dissimilar elements will cancel out each other
- only the majority one won't be canceled, & thus it'll be returned as answer


### Code
    public static int findMajority(int[] arr, int n) {
		 int count=0;
        int candidate=0;
        for (int i=0; i< n; i++){
            if(count==0) {
                candidate = arr[i];
            }
            else if(arr[i]==candidate){
                count+=1;
            }else {
                count-=1;
            }
        }

        return candidate;
	}


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)