### Question
- Given two strings s and t, return true if t is an anagram of s, and false otherwise. 
- An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### Sample Input
    s = "anagram", t = "nagaram"
    s = "rat", t = "car"

### Sample Output
    true
    false

### Solution
- If both the strings are of unequal length return false
- we will have an array whose each index points to each character of english alphabet and use this as a hash table
- everytime we encounter a character of string s, we will increase its value in hash table
- and everytime we encounter a character of string t, we will decrease its value in hash table
- if both the strings are anagram of each other, then all characters of s will cancel out all character of t
- i.e., if in our hash table, we find a value not equal to 0, we will return false

### Code
    public static boolean isAnagram(String s, String t){
        if (s.length()!=t.length()) return false;
        int[] store= new int[26];
        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i)-'a']++;
            store[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < store.length; i++) {
            if (store[i]!=0) return false;
        }
        return true;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(26)