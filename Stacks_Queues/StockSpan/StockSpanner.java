package Stacks_Queues.StockSpan;

import java.util.Stack;

public class StockSpanner {
    Stack<int[]> res;

    public StockSpanner(){
        res= new Stack<>();
    }

    public int next(int price){
        int span=1;
        while (!res.isEmpty() && res.peek()[0] <= price){
            span += res.pop()[1];
        }
        res.push(new int[]{price, span});
        return span;
    }
}
