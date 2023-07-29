package BinaryTrees.LeftView;

import java.util.ArrayList;

public class Code {
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }


    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res= new ArrayList<>();
        getLeftView(root, res, 0);
        return res;
    }

    private void getLeftView(Node root, ArrayList<Integer> res, int level) {
        if (root==null) return;
        if (level==res.size()) res.add(root.data);

        getLeftView(root.left, res, level+1);
        getLeftView(root.right, res, level+1);
    }
}
