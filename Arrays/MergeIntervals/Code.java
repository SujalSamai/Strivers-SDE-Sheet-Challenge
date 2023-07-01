package Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        int n = intervals.length;
        ArrayList<Interval> ans = new ArrayList<Interval>();

        if(intervals.length == 0 || intervals == null) {
            return ans;
        }

        // sort the starting points by ascending order
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals[0].start;
        int end = intervals[0].finish;

        // for an interval, compare its end with the next intervals start
        for(Interval interval : intervals) {
            if(interval.start <= end) {
                end = Math.max(end, interval.finish);
            }
            else {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.finish;
            }
        }

        ans.add(new Interval(start, end));
        return ans;
    }

    //leetcode
    public int[][] merge(int[][] intervals) {
        //if there is only one pair, return it as it is
        if(intervals.length<1) return intervals;

        //sort intervals, according to the first element if each pair
        //Sorting is important to merge overlapping elements, Ask interviewer beforehand, if pairs are already sorted
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);

        List<int[]> res=new ArrayList<>();  //resultant list -> will be converted to 2-d array
        int start=intervals[0][0];
        int end=intervals[0][1];

        //for each pair in intervals
        for (int[]pair:intervals){
            //checks the first index of each pair, & decides if it is less than the current end(last index of previous pair)
            //if yes, this pair will be merged and its end will be updated based on which pair's index=1 element is greater
            if(pair[0]<=end){
                end=Math.max(end, pair[1]);
            }
            //otherwise, we will add the current pair into our list & update start and last to first and second index of current pair
            else{
                res.add(new int[]{start,end});
                start=pair[0];
                end=pair[1];
            }
        }

        //add the last pair
        res.add(new int[]{start,end});

        //convert list to 2-d array
        return res.toArray(new int[0][]);
    }
}
