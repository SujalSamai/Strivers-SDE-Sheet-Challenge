package BinarySearchTrees.FloorBST;

public class Code {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while (root!=null){
            if (root.data==X){
                floor= root.data;
                return floor;
            }
            if (X > root.data){
                floor= root.data;
                root= root.right;
            }else{
                root= root.left;
            }
        }
        return floor;
    }
}
