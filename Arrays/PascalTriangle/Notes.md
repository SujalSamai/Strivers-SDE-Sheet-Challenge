### Question
- Given an integer numRows, return the first numRows of Pascal's triangle.

### Sample Input
    5
    1

### Sample Output
    [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    [[1]]

### Solution
- we will traverse the list and we will add an arraylist in each iteration
- add the first arraylist as 1
- later on, in each iteration, we will again traverse till ith element
- if the element is first or last in the list, just add 1
- else add list[i-1][j-1] + list[i-1][j]

### Code
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Long> temp= new ArrayList<>();
            if(i==0) temp.add(1L);
            else{
                for(int j=0; j<=i; j++){
                    if(j==0 || j==i){
                        temp.add(1L);
                    }else{
                        temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*N)
2. Space Complexity - O(1)