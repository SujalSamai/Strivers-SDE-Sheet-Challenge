package Stacks_Queues.NearestSmaller;

import java.util.Arrays;
import java.util.Stack;

public class Code {
    public static void main(String[] args) {
        int[] arr= {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stack= new Stack<>();
        int[] res= new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek()>=A[i]){
                stack.pop();
            }
            if (!stack.isEmpty()) res[i]=stack.peek();
            else res[i]=-1;
            stack.push(A[i]);
        }
        return res;
    }
}
