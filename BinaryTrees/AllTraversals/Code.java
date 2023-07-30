package BinaryTrees.AllTraversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static class Pair{
        BinaryTreeNode<Integer> node;
        int num;
        Pair(BinaryTreeNode<Integer> node, int num){
            this.node=node;
            this.num=num;
        }
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> pre= new ArrayList<>();
        List<Integer> in= new ArrayList<>();
        List<Integer> post= new ArrayList<>();
        if (root==null) return res;
        Stack<Pair> st= new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()){
            Pair it= st.pop();
            if (it.num==1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.num==2){
                in.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.right!=null){
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else {
                post.add(it.node.data);
            }
        }
        res.add(in);
        res.add(pre);
        res.add(post);
        return res;
    }
}
