### Question
- Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

### Sample Input
    abc
    aa

### Sample Output
    a ab abc ac b bc c
    a a aa

### Solution
- Maintain a temp string (say f),which is empty initally. 
- Now you have two options,either you can pick the character or not pick the character and move to the next index. 
- Firstly we pick the character at ith index and then move to the next index.(f + s[i])
- If the base condition is hit,i.e i==s.length() ,then we print the temp string and return. 
- Now while backtracking we have to pop the last character since now we have to implement the non-pick condition and then move to next index.

### Code
    public List<String> AllPossibleStrings(String s) {
        List<String> ans= new ArrayList<>();
        String cur="";
        int i=0;
        powerSet(s, i, cur, ans);
        Collections.sort(ans);
        return ans;
    }

    private void powerSet(String s, int i, String cur, List<String> ans) {
        if (i==s.length()){
            if (!cur.isEmpty()){
                ans.add(cur);
            }
            return;
        }

        powerSet(s, i+1, cur+s.charAt(i), ans);
        powerSet(s, i+1, cur, ans);
    }

### Complexity
1. Time Complexity - O(2^N)
2. Space Complexity - O(N)