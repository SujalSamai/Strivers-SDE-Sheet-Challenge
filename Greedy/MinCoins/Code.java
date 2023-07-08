package Greedy.MinCoins;

import java.util.ArrayList;

public class Code {
    //display the amount of coins used
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

    //display the coins
    public static ArrayList<Integer> minCoins(int amount) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = coins.length-1; i >= 0 ; i--) {
            while (amount>=coins[i]){
                amount -= coins[i];
                ans.add(coins[i]);
            }
        }
        return ans;
    }
}
