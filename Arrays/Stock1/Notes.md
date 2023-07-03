### Question
- You are given an array prices where prices[i] is the price of a given stock on the ith day. 
- You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. 
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### Sample Input
    [7,1,5,3,6,4]
    [7,6,4,3,1]

### Sample Output
    5
    0

### Solution
- We will keep track the maximumProfit till current element & also track the minimum element till now
- Traverse the arr, calculate the curProfit
- update maxProfit & update the minimum element

### Code
    public static int maximumProfit(ArrayList<Integer> prices){
        int maximumProfit=0, mini=prices.get(0);
        for(int i=1; i<prices.size(); i++){
            int curProfit= prices.get(i)-mini;
            maximumProfit= Math.max(maximumProfit, curProfit);
            mini= Math.min(mini, prices.get(i));
        }
        return maximumProfit;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)