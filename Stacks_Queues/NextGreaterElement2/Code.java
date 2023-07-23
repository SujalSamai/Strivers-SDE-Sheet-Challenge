package Stacks_Queues.NextGreaterElement2;

import java.util.Arrays;
import java.util.Stack;

public class Code {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];

        for(int i= 2*n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if (i<n){
                if (!st.isEmpty()){
                    res[i]=st.peek();
                }else{
                    res[i]=-1;
                }
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}
