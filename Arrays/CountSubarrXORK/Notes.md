### Question
- Given an array of integers and an integer 'X', you are supposed to find the number of subarrays of arr which have bitwise XOR of the elements equal to X

### Sample Input
    [5,3,8,3,10]  X=8
    [10,1,0,3,4,7] X=11

### Sample Output
    2
    3

### Solution
- We will use a hashmap to store xor till current index and count of how many times it appeared
- initially we will put 0,1 in the map
- now traverse the arr, add the current element in the xor, and get k=xr^x (in order for xr^x to be 0, we must have k in our subarr)
- after finding k, check if k is there in the map, if it's there then we found a required subarray, increase count till the count we have got already
- else just put xr in the map & add 0 in its value, if it's not there already, else add 1 to it


### Code
    public static int subarraysXor(ArrayList<Integer> arr, int x){
        int xr=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(xr,1);
        int count=0;

        for (int i = 0; i < arr.size(); i++) {
            xr=xr^arr.get(i);
            int k= xr^x;

            if (map.containsKey(k)){
                count+=map.get(k);
            }

            map.put(xr, map.getOrDefault(xr, 0)+1);
        }
        return count;
    }

### Edge Cases
- NA

### Other Techniques
- Generating all subarrays using nested loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)