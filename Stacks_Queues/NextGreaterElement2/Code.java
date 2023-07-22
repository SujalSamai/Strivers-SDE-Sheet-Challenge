package Stacks_Queues.NextGreaterElement2;

import java.util.Arrays;
import java.util.Stack;

public class Code {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums){
        Stack<Integer> st= new Stack<>();
        int[] res= new int[nums.length];

        //push all the elements of the array to stack from back side
        for(int i = nums.length - 1; i >= 0; i --) {
            st.push(nums[i]);
        }

        for (int i = nums.length-1 ; i >= 0 ; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else{
                res[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
}
