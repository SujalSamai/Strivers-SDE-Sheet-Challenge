### Question
- Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day. 
- The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day. 
  - For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days. 
  - Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days. 
- Implement the StockSpanner class:
  - StockSpanner() Initializes the object of the class. 
  - int next(int price) Returns the span of the stock's price given that today's price is price.

### Sample Input
    ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
    [[], [100], [80], [60], [70], [60], [75], [85]]

### Sample Output
    [null, 1, 1, 1, 2, 1, 4, 6]


### Solution
- we will take a stack which stores pair of values, i.e., price & span
- initially span=1 as we are also considering the current Day in the span
- if stack is empty push price & span=1
- if it is not empty & top of stack <= price keep on popping from stack and add the span of those numbers in our span, then push price and calculated span again
- In the stack we are essentially keeping track of the previous greater price, for eg: we have [100,80,60,70,60,75] -> for 80 previous greater 100 so span=1, for 75 previous greater is 80, so span => 4

### Code
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

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)