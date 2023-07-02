### Question
- You are given an arr of size N. The elements of the array are in range 1 to N.
- Due to some miscalculation, there is number which appears twice and a number which is missing
- Return both the numbers

### Sample Input
    [6,4,3,5,5,1]

### Sample Output
    [2,5]

### Solution
- We will count the occurrences of each element and store it in our array
- As elements are in range of 1 to N, if an element has occurrence of 2 then we will add in our res
- and similarly if an element occurrence is 0, add in res arr

### Code
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] countOccurences = new int[n];
        for (int i = 0; i < n; i++) {
            countOccurences[arr.get(i)-1]++;
        }
        int[] res= new int[2];
        for (int i = 0; i < n; i++) {
            if(countOccurences[i]==0){
                res[0]=i+1;
            }
            if(countOccurences[i]==2){
                res[1]=i+1;
            }
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops
- XOR
- Maths

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)