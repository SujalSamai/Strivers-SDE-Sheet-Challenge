### Question
- Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of the given string.

### Sample Input
    str = "ababbbabbababa"
    str = "aaabba"

### Sample Output
    3
    1

### Solution
- The initial idea will be to make partitions to generate substring and check if the substring generated out of the partition will be a palindrome. Partitioning means we would end up generating every substring and checking for palindrome at every step.
- we will create a dp[n][n] where n is length of string, and we will use 2 pointers one at starting of string, and one at end
- if s>=e, then we can't do further partitions, & thus no palindromes too so return 0
- if the given indexes already forms palindrome, then return 0
- Check if the current indexes has already any value in dp, if yes then return the value
- Now start traversing from start to end, we will make two partitions, first from start to current index & second from current index+1 to end. We have stored these first & second in dp to improve complexity
- Now total partitions will become first+second+1
- Get the minimum ans, and store it in dp & return it

### Code
    static int palindromicPartition(String str) {
        int n= str.length();
        int[][] dp= new int[n][n];
        for (int[] row: dp) Arrays.fill(row, -1);
        return getPartitions(str, 0, n-1, dp);
    }

    private static int getPartitions(String str, int s, int e, int[][] dp) {
        if (s>=e) return 0;
        if (isPalindrome(str, s, e)) return 0;
        int min= Integer.MAX_VALUE;
        if (dp[s][e]!=-1) return dp[s][e];

        int first=0, second=0;
        for (int i = s; i < e; i++) {
            if (dp[s][i]!=-1){
                first = dp[s][i];
            }else{
                first = getPartitions(str, s, i, dp);
                dp[s][i]= first;
            }

            if (dp[i+1][e]!=-1){
                second = dp[i+1][e];
            }else{
                second= getPartitions(str, i+1, e, dp);
                dp[i+1][e]= second;
            }
            int total = first+second+1;
            min= Math.min(min, total);
        }
        dp[s][e]=min;
        return min;
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s<e){
            if (str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*N)
2. Space Complexity - O(N*N)