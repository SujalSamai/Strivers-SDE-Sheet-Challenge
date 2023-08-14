package Trie.CompleteString;

public class Code {
    static class trie{
        boolean isEnd = false;
        trie[] children = new trie[26];
    }

    static trie root;
    public static String completeString(int n, String[] a) {
        root = new trie();
        for(String str : a){
            insert(str);
        }

        String longest = "";
        for(String word : a){
            if(checkIfAllPrefixExists(word)){
                if(word.length() > longest.length()){
                    longest = word;
                }
                else if((word.length() == longest.length()) && word.compareTo(longest) < 0){
                    longest = word;
                }
            }
        }

        return longest == "" ? "None" : longest;
    }

    public static boolean checkIfAllPrefixExists(String word){
        trie node = root;
        boolean flag = true;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] != null){
                node = node.children[ch - 'a'];
                flag = flag && node.isEnd;
            }
            else return false;
        }
        return flag;
    }

    public static void insert(String word){
        trie node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new trie();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }
}
