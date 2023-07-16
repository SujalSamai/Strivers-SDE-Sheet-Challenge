### Question
- Write a program to solve a Sudoku puzzle by filling the empty cells.
- A sudoku solution must satisfy all of the following rules:
- Each of the digits 1-9 must occur exactly once in each row.
- Each of the digits 1-9 must occur exactly once in each column.
- Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
- The '.' character indicates empty cells.

### Sample Input
    dict = god is now no where here
    s = godisnowherenowhere 

    dict = god is no here
    s = godisnowhere

### Sample Output
    god is no where no where
    god is no where now here
    god is now here no where
    god is now here now here

    No output to be printed

### Solution
- Store all words of the dictionary in a set to speed up the process of checking whether a current word exists in the dictionary or not. 
- Base condition, If we have checked for all the substrings, then just return with a list containing only a null string 
- Else, Start exploring every substring from the start of the string and check if it is in the HashSet. 
- If it is present in the HashSet: Check if it is possible to form the rest of the sentence using dictionary words. If yes, you append the current substring to all the substrings possible from the rest of the sentences. 
- If none of the substrings of sentences are present in the HashSet, then there are no sentences possible from the current string. 
- Return all the valid output sentences.

### Code
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        HashSet<String> set = new HashSet<>(dictionary);

        ArrayList<String> res= new ArrayList<>();
        solve(0, s, new ArrayList<>(), set, res);
        return res;
    }

    private static void solve(int ind, String s, ArrayList<Object> list, HashSet<String> set, ArrayList<String> res) {
        if (ind==s.length()){
            StringBuilder str= new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                str.append(list.get(i));
                str.append(" ");
            }
            res.add(str.toString());
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (set.contains(s.substring(ind, i+1))){
                list.add(s.substring(ind, i+1));
                solve(i+1, s, list, set, res);
                list.remove(list.size()-1);
            }
        }
    }

### Other Techniques
- Hashmap
- Trie

### Complexity
1. Time Complexity - O(N * (2 ^ (N - 1)))
2. Space Complexity - O(N * (2 ^ (N - 1)))