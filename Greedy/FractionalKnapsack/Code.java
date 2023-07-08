package Greedy.FractionalKnapsack;

import java.util.Comparator;
import java.util.Arrays;

public class Code {
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
}
