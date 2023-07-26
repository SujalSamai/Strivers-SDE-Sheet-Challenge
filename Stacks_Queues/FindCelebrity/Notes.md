### Question
- Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.
- Now you want to find out who the celebrity is or verify that there is not one. You are only allowed to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense). 
- You are given a helper function bool knows(a, b) that tells you whether a knows b. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party. 
- Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.

### Sample Input
    graph = [[1,1,0],[0,1,0],[1,1,1]]
    graph = [[1,0,1],[1,1,0],[0,1,1]]
### Sample Output
    1
    -1

### Solution
``Important: A celebrity is someone who is doesn't know anybody, but everybody else knows him``
- The knows function automatically returns if a is connected to b or not
- We will make 0 as our candidate and traverse from 1 to n and check if our candidate knows ith node, if it knows then this can't be celebrity, so make i as candidate and repeat
- This way, we will have our potential candidate, now again traverse other remaining nodes, and check if the candidate knows them or don't they know candidate -> in both cases return -1
- else return candidate

### Code
     public static int findCelebrity(int n){
        int candidate=0;
        for (int i = 1; i < n; i++) {
            if(knows(candidate,i)){
                candidate=i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i==candidate) continue;
            else{
                if (knows(candidate,i) || !knows(i, candidate)) return -1;
            }
        }
        return candidate;
    }

    //its implementation is already defined as an API by Leetcode, we have to assume that it tells whether a is connected to b
    private static boolean knows(int a, int b){
        return false;
    }


### Other Techniques
- Nested loops and array for storing

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)