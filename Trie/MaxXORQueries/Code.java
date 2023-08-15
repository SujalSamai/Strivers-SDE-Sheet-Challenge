package Trie.MaxXORQueries;

import java.util.Arrays;

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

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] offlineQueries = new int[queries.length][3];
        int[] ans= new int[queries.length];
        for (int i=0; i< queries.length; i++){
            offlineQueries[i][0]= queries[i][1];
            offlineQueries[i][1]= queries[i][0];
            offlineQueries[i][2]=i;
        }

        Arrays.sort(offlineQueries,(o1,o2)-> o1[0]-o2[0]);
        int ind=0;
        Trie t= new Trie();
        Arrays.fill(ans, -1);

        for (int i = 0; i < queries.length; i++) {
            while (ind < nums.length && nums[ind] <= offlineQueries[i][0]){
                t.insert(nums[ind]);
                ind++;
            }

            int queryInd = offlineQueries[i][2];
            if (ind!=0) ans[queryInd] = t.getMax(offlineQueries[i][1]);
            else ans[queryInd]=-1;
        }
        return ans;
    }
}
