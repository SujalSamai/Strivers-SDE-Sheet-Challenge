### Question
- Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

### Sample Input
    [1,3,-1,4,-4]
    [1,-1,2,-2]

### Sample Output
    2
    4

### Solution
- The main intuition is, if suppose a subarray sum is "S", and within that subarr there are two subarr "A" & "B". Now if sum of elements in A is "S" too, we know sum of elements in "B" will automatically be 0.
- We will use a Hashmap to add prefixSum & index value, also maintain a maxi
- Traverse the arr & keep on adding each element to sum
- if our prefixSum comes to be zero, that means this is a required subarr, so make maxi=i+1 as this is the size of the subarr
- if prefixSum is already present in our map, then that means there was a subarr earlier with same sum, meaning the first case mentioned here has happened.
- Update the maxi accordingly
- else just put prefixSum & index in the map


### Code
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr){
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxi=0, prefixSum=0;

        for (int i = 0; i < arr.size(); i++) {
            prefixSum+= arr.get(i);
            if (map.containsKey(prefixSum)){
                maxi=Math.max(maxi, (i-map.get(prefixSum)));
            }else if(prefixSum==0){
                maxi=i+1;
            }else{
                map.put(prefixSum,i);
            }
        }
        return maxi;
    }

### Edge Cases
- NA

### Other Techniques
- Generating all subarrays using nested loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)