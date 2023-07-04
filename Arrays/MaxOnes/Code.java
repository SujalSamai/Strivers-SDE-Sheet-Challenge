package Arrays.MaxOnes;

public class Code {
    public static int findMaxConsecutiveOnes(int[] arr){
        int max=0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1){
                sum+=arr[i];
                if (sum>max) max=sum;
            }else{
                sum=0;
            }
        }
        return max;
    }
}
