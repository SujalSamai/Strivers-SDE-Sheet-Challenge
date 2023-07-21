package Stacks_Queues.QueueUsingStack;

import java.util.Stack;

public class Code {
    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        Queue() {
            // Initialize your data structure here.
            s2=new Stack<>();
            s1=new Stack<>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            if(s1.isEmpty()){
                s1.push(val);
            }else{
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(val);
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

        int deQueue() {
            if(s1.isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        int peek() {
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }

        boolean isEmpty() {
            return s1.isEmpty();
        }
    }
}
