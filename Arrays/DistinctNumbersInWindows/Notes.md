### Question
- You are given an array 'ARR' of size 'N' and an integer 'K'.
- Your task is to find the total number of distinct elements present in every 'K' sized window of the array
- A 'K' sized window can also be viewed as a series of continuous 'K' elements present in the sequence.

### Sample Input
    arr= [1 2 1 3 4 2 3], k = 4
    arr= [1 1 2 1 3], k = 3

### Sample Output
    3 4 4 3
    2 2 3

### Solution
- We will use a Hashmap here
- Initially we put the first k elements in the hashmap with their frequencies, as hashmap stores distinct elements, we can add map.size in our result
- Next we do iteration from k, now we will follow a sliding window approach, we will decrease the frequency of first number of given arr (i.e., deleting the first number in given arr)
- Now if the value of the first number becomes 0, that means in our next window, that element is not present, so we remove it from our map
- then we add the next element i.e. kth element in the map, and again add the map size in our ans
- and we keep on repeating this

### Code
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        ArrayList<Integer> ans= new ArrayList<>();

        for (int i = 0; i < k; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
        }
        ans.add(map.size());

        int p=0;
        for (int i = k; i < arr.size(); i++) {
            map.put(arr.get(p), map.getOrDefault(arr.get(p),0)-1);
            if (map.get(arr.get(p))==0){
                map.remove(arr.get(p));
            }
            p++;
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
            ans.add(map.size());
        }
        return ans;
    }

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)