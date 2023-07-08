### Question
- Dora visits India and decides to try Indian food. However, the restaurant accepts only Indian currency i.e. [1,2,5,10,20,50,100,500,1000] valued coins.
- So dora goes to a bank which has infinite supply of denominations to make a change for the given 'Amount'. 
- As a cashier, you have to provide the minimum number of coins that add up to the given 'Amount'.

### Sample Input
    13
    20

### Sample Output
    3
    1

### Solution
- It's better to use higher denominations so as to minimize the number of coins
- We will store all denominations in an array and we will traverse this array from back side
- while the amount is not less than the particular coin value, we will keep subtracting it from amount and increase count

### Code
    public static int findMinimumCoins(int amount) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int count=0;
        for (int i = coins.length-1; i >= 0 ; i--) {
            while (amount>=coins[i]){
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(V), V is the amount
2. Space Complexity - O(1)