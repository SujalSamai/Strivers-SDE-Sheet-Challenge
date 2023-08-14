package Trie.Implementation2;

public class Trie {
    static class Node {
        Node[] links = new Node[26];
        int cntEndsWith = 0;
        int cntPrefix = 0;

        public Node(){}

        boolean containsKey(char ch){
            return (links[ch-'a']!=null);
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        void increaseEnd(){
            cntEndsWith++;
        }
        void increasePrefix() {
            cntPrefix++;
        }
        void deleteEnd() {
            cntEndsWith--;
        }
        void reducePrefix() {
            cntPrefix--;
        }
        int getEnd() {
            return cntEndsWith;
        }
        int getPrefix() {
            return cntPrefix;
        }
    }

    private static Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node= root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.deleteEnd();
    }
}
