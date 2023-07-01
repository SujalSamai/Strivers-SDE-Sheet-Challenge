package Arrays.FindDuplicate;

import java.util.ArrayList;
import java.util.HashSet;

public class Code {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        //System.out.println(findDuplicate(list, list.size()));
        int[] arr={1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if(set.contains(arr.get(i))){
                return arr.get(i);
            }else{
                set.add(arr.get(i));
            }
        }
        return -1;
    }

    //leetcode optimal without extra space
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        //just means slow=slow.next & fast=fast.next.next
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
