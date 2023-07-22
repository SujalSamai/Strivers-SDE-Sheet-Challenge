package Stacks_Queues.SortStack;

import java.util.Stack;

public class Code {
    public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int num=stack.pop();
        sortStack(stack);
        sorting(stack,num);
    }

    public static void sorting(Stack<Integer> stack, int num){
        if(stack.isEmpty() || stack.peek() < num){
            stack.push(num);
            return;
        }
        int n= stack.pop();
        sorting(stack, num);
        stack.push(n);
    }
}
