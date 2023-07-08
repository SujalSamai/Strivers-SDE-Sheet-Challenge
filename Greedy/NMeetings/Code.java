package Greedy.NMeetings;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        int n=start.length;
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> innerList= new ArrayList<>();
            innerList.add(start[i]);
            innerList.add(end[i]);
            innerList.add(i);
            list.add(innerList);
        }

        list.sort((a, b) -> (a.get(1) - b.get(1)));
        List<Integer> res= new ArrayList<>();
        int el= list.get(0).get(1);
        res.add(list.get(0).get(2)+1);
        for(int i=1; i<list.size(); i++){
            if(el<list.get(i).get(0)){
                res.add(list.get(i).get(2)+1);
                el=list.get(i).get(1);
            }
        }
        return res;
    }
}
