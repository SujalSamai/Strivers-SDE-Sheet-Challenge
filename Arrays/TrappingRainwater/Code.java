package Arrays.TrappingRainwater;

public class Code {
    public static void main(String[] args) {
        int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] arr){
        int total=0;
        int left=0;
        int right= arr.length-1;
        int high1=arr[left];
        int high2= arr[right];

        while (left<right){
            if (high1<high2){
                left++;
                high1= Math.max(high1, arr[left]);
                total+= high1 - arr[left];
            }else{
                right--;
                high2= Math.max(high2, arr[right]);
                total+= high2 - arr[right];
            }
        }
        return total;
    }
}
