### Question
- You are given N activities with their start time Start[] and finish time Finish[]. You need to tell the maximum number of activities a single person can perform

### Sample Input
    start = [1, 6, 2, 4], end= [2, 7, 5, 8]
    start = [1, 1, 1], end= [4, 5, 9]

### Sample Output
    3
    1

### Solution
- if we choose an activity that finishes early we can accommodate more activities. Hence we should choose activities that end early and utilize the remaining time for more activities.
- To proceed we need a ds of two quantities: the starting time, ending time. Sort this data structure in ascending order of end time.
- since we can always do 1 activity, we will initialize ans=1
- then we will check if any time, the prev end time<= current start time, increment res

### Code
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

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(NlogN) + O(N)
2. Space Complexity - O(N)