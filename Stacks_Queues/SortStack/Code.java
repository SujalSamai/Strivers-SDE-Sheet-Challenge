package Stacks_Queues.SortStack;

import java.util.Stack;

public class Code {
    public static void sortStack(Stack<Integer> stack) {
        if(stack.size()==1) return;
        int temp= stack.pop();
        sortStack(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int num){
        if(stack.size()==0 || stack.peek()<num){
            stack.push(num);
            return;
        }
        int val= stack.pop();
        insert(stack, num);
        stack.push(val);
    }
}
