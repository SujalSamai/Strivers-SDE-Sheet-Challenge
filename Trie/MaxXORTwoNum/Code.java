package Trie.MaxXORTwoNum;

public class Code {
    static class Node{
        Node[] links= new Node[2];  //for 0 or 1
        Node(){}
        boolean containsKey(int n){
            return links[n]!=null;
        }
        void put(int n, Node node){
            links[n]=node;
        }
        Node get(int n){
            return links[n];
        }
    }

    static class Trie{
        Node root;
        Trie(){
            root=new Node();
        }
        void insert(int n){
            Node node= root;
            for (int i = 31; i >=0 ; i--) {
                int bit = (n>>i) & 1;   //checking if ith bit is set or not
                if (!node.containsKey(bit)){
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int getMax(int n){
            Node node = root;
            int res=0;
            for (int i = 31; i >=0 ; i--) {
                int bit = (n >> i) & 1;
                if (node.containsKey(1-bit)){   //if we have opposite of the bit in our node
                    res = res | (1 << i);           // add it to our ans by doing OR
                    node = node.get(1 - bit);
                }else{
                    node = node.get(bit);
                }
            }
            return res;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie t= new Trie();
        for (int num : nums){
            t.insert(num);
        }

        int maxi=0;
        for (int num:nums){
            maxi = Math.max(maxi, t.getMax(num));
        }
        return maxi;
    }
}
