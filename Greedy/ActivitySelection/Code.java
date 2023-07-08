package Greedy.ActivitySelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity{
    int start;
    int end;
    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class comp implements Comparator<Activity> {
    public int compare(Activity a, Activity b){
        return a.end - b.end;
    }
}

public class Code {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        ArrayList<Activity> ls = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            ls.add(new Activity(start.get(i),end.get(i)));
        }
        Collections.sort(ls, new comp());
        int ans = 1;
        int limit = ls.get(0).end;
        for(int i=1;i<ls.size();i++){
            if(ls.get(i).start >= limit){
                limit = ls.get(i).end;
                ans++;
            }
        }
        return ans;
    }
}
