package Trie.CountDistinctSubstr;

public class Code {
    static class Node {
        Node[] links = new Node[26];
        public Node(){}
        boolean containsKey(char ch){
            return (links[ch-'a']!=null);
        }

        void put(char ch, Node node){
            links[ch-'a']=node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }
    }

    public static int countDistinctSubstrings(String s) {
        Node root= new Node();
        int count=0;
        int n= s.length();
        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j), new Node());
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return count+1;
    }
}
