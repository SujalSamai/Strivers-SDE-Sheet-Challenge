### Question
- You are given the schedule of N meetings with their  start time Start[i] and end time End[i]. But you have only 1 meeting room.
- So you need to tell the meeting members you can organize in the given room, such that the number of meetings organized is maximum

### Sample Input
    start = [1, 3, 0, 5, 8, 5], end= [2, 4, 6, 7, 9, 9]
    start = [1, 1, 1], end= [4, 5, 9]

### Sample Output
    [1, 2, 4, 5]
    [1]

### Solution
- if we choose a meeting that finishes early we can accommodate more meetings. Hence we should choose meetings that end early and utilize the remaining time for more meetings.
- To proceed we need a list of three quantities: the starting time, ending time, meeting number. Sort this data structure in ascending order of end time.
- Since the pos should start from 1 based indexing, we will add initially the position+1 of first element of our sorted list, as one meeting can always be done
- then we traverse the list, and check if the last end time < current start time, if yes add to the result and update our end time.

### Code
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

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(NlogN) + O(N)
2. Space Complexity - O(N)