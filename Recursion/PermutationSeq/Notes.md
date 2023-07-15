### Question
- The set [1, 2, 3, ..., n] contains a total of n! unique permutations. 
- By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
- Given n and k, return the kth permutation sequence.

### Sample Input
    n = 3, k = 3
    n = 4, k = 9

### Sample Output
    "213"
    "2314"

### Solution
- We will first find the factorial of N & push all the n integers into an array
- Since we are using 0 based indexing, k actually will be k-1 position
- now we will check the array, and add the first number that will be right for our permutation by doing k/fact
- Now remove that number from our array as we don't need it anymore
- next our k will become k%fact and our remaining factorial can be calculated using fact/arr.size
- do this till our array becomes empty and return ans

### Code
    public static String getPermutation(int n, int k){
        int fact=1;
        //find the factorial of n & push all the n integers into an array
        ArrayList<Integer> arr= new ArrayList<>();
        for (int i = 1; i <n; i++) {
            fact= fact*i;
            arr.add(i);
        }
        arr.add(n);
        String ans="";
        //since we are using 0 based indexing, k will become k-1
        k=k-1;
        while (true){
            ans= ans + "" + arr.get(k/fact);
            arr.remove(k/fact);
            if (arr.size()==0) break;

            k=k%fact;
            fact= fact/arr.size();
        }
        return ans;
    }

### Other Techniques
- Recursion - generate all permutations and sort them O(n!*n)+ N!lognN

### Complexity
1. Time Complexity - O(n^2)
2. Space Complexity - O(N)