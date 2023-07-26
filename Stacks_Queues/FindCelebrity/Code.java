package Stacks_Queues.FindCelebrity;

public class Code {
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
}
