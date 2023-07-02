### Question
- Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

### Sample Input
    intervals = [[1,3],[2,6],[8,10],[15,18]]
    intervals = [[1,4],[4,5]]

### Sample Output
    [[1,6],[8,10],[15,18]]
    [[1,5]]

### Solution
- sort intervals, according to the first element if each pair 
- Sorting is important to merge overlapping elements, Ask interviewer beforehand, if pairs are already sorted
- take two pointers, one which mark the first index of each pair, other marks the second index
- traverse the matrix, pair wise. check the first index of each pair, & decides if it is less than the current end(last index of previous pair)
- if yes, this pair will be merged and its end will be updated based on which pair's index=1 element is greater
- otherwise, we will add the current pair into our list & update start and last to first and second index of current pair

### Code
    public int[][] merge(int[][] intervals) {
        if(intervals.length<1) return intervals;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();  //resultant list -> will be converted to 2-d array
        int start=intervals[0][0];
        int end=intervals[0][1];

        for (int[]pair:intervals){
            if(pair[0]<=end){
                end=Math.max(end, pair[1]);
            }
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

### Edge Cases
- if there is only one pair, return it as it is

### Complexity
1. Time Complexity - O(NlogN)
2. Space Complexity - O(N)