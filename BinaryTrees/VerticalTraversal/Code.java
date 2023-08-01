package BinaryTrees.VerticalTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Code {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        preorderTraversal(root, 0, 0, map);
        List<List<Integer>> ans= new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> inMap: map.values()){
            ArrayList<Integer> temp= new ArrayList<>();
            for (PriorityQueue<Integer> pq: inMap.values()){
                while (!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    private static void preorderTraversal(TreeNode root, int level, int posIndex, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root==null) return;
        map.putIfAbsent(posIndex, new TreeMap<>());
        map.get(posIndex).putIfAbsent(level, new PriorityQueue<Integer>());
        map.get(posIndex).get(level).add(root.val);

        preorderTraversal(root.left, level+1, posIndex-1, map);
        preorderTraversal(root.right, level+1, posIndex+1, map);
    }
}
