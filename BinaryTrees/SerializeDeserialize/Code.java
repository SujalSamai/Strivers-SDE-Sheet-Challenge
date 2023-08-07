package BinaryTrees.SerializeDeserialize;

import java.util.LinkedList;
import java.util.Queue;

public class Code {
    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res= new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node==null){
                res.append("# ");
                continue;
            }
            res.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values= data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1; i< values.length; i++){
            TreeNode parent= q.poll();
            if (!values[i].equals("#")){
                TreeNode left= new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}
