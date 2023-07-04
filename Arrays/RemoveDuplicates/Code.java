package Arrays.RemoveDuplicates;

public class Code {
    public static int removeDuplicates(int[] arr){
        int count=0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[count]!=arr[i]){
                count++;
                arr[count]=arr[i];
            }
        }
        return count+1;
    }
}
