### Question
- You have been given weights and values of 'N' items. You are also given a knapsack of size 'W'.
- Your task is to put the items in the knapsack such that the total values of items in the knapsack is maximum

### Sample Input
    Pair = [[50 40 90 120 10 200][40 50 25 100 30 45]], n=6, w=200
    Pair = [[20 24 36 40 42][12 35 41 25 32]], n=5, w=100

### Sample Output
    204.00
    106.48

### Solution
- The greedy method to maximize our answer will be to pick up the items with higher values. Since it is possible to break the items as well we should focus on picking up items having higher value /weight first.
- To achieve this, items should be sorted in decreasing order with respect to their value /weight.
- Iterate & Pick up items with weight lesser than or equal to the current capacity of the knapsack.
- In the end, if the weight of an item becomes more than what we can carry, break the item into smaller units. Calculate its value according to our current capacity and add this new value to our answer.

### Code
    static class Pair {
        int weight;
        int value;
        Pair(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }
    }
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items,new Comparator<Pair>(){
            public int compare(Pair i1, Pair i2) {
                return i2.value * i1.weight - i2.weight * i1.value;
            }
        });

        double ans=0;
        for (int i = 0; i < n; i++) {
            if (w > items[i].weight){
                ans += items[i].value;
                w -= items[i].weight;
            }else {
                ans += ((double) items[i].value * w) / (double) items[i].weight;
                break;
            }
        }
        return ans;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(NlogN) + O(N)
2. Space Complexity - O(1)