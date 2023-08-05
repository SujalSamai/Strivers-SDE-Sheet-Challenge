package BinarySearchTrees.KthLargestBST;

public class Code {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }

    public int kthLargest(Node root, int K){
        int[] res= {0, -1};     // res[0]= count, res[1]=result
        inorder(root, K, res);
        return res[1];
    }

    private void inorder(Node root, int k, int[] res) {
        if (root==null) return;

        inorder(root.right, k, res);
        res[0]= res[0]+1;   //count++

        if (res[0]==k){     //count==k, return result
            res[1]=root.data;
            return;
        }

        inorder(root.left, k, res);
    }
}
