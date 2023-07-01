package Arrays.Stock1;

import java.util.ArrayList;

public class Code {
//    TC- O(n) SC-O(1)
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int maximumProfit=0, mini=prices.get(0);
        for(int i=1; i<prices.size(); i++){
            int curProfit= prices.get(i)-mini;
            maximumProfit= Math.max(maximumProfit, curProfit);
            mini= Math.min(mini, prices.get(i));
        }
        return maximumProfit;
    }
}
