package Stacks_Queues.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Code {
    static class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public Stack() {
           q1= new LinkedList<>();  //Queue is implemented through LL in java
            q2= new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            if (q1.isEmpty()) return 0;
            else return q1.size();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public void push(int element) {
            while (!q1.isEmpty()) {
                q2.add(q1.element());
                q1.remove();
            }
            q1.add(element);
            while (!q2.isEmpty()) {
                q1.add(q2.element());
                q2.remove();
            }
        }

        public int pop() {
            if (q1.isEmpty()) return -1;
            else{
                int ans= q1.peek();
                q1.poll();
                return ans;
            }
        }

        public int top() {
            if (q1.isEmpty())  return -1;
            else return q1.peek();
        }
    }
}

//Using one queue in push operation
//     q1.add(element);
//        for (int i = 0; i < q1.size()-1; i++) {
//            q1.add(q1.peek());
//            q1.poll();
//        }