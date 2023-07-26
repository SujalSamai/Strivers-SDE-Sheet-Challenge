package Stacks_Queues.MaxMinOfWindow;

import java.util.Arrays;
import java.util.Stack;

public class Code {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] left=new int[n];
        int[] right=new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        Stack<Integer> st=new Stack<>();

        //finding previous smaller
        left[0] = -1;
        st.push(0);
        for(int i=1;i<n;i++) {
            while(!st.empty() && a[st.peek()]>=a[i]) {
                st.pop();
            }
            left[i]=st.empty()?-1:st.peek();
            st.push(i);
        }

        st.clear();

        //finding next smaller
        right[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!st.empty() && a[st.peek()]>=a[i]) {
                st.pop();
            }
            right[i]=st.empty()?n:st.peek();
            st.push(i);
        }


        for(int i=0;i<n;i++) {
            int len=right[i]-left[i]-1;
            ans[len-1]=Math.max(ans[len-1],a[i]);
        }
        for(int i=n-2;i>=0;i--) {
            ans[i]=Math.max(ans[i],ans[i+1]);
        }

        return ans;
    }
}
