public class Main {
    public static void main(String[] args) {

       /* int[] nums={1,0,1,0,1};
        int goal=2;*/
        int[] nums={0,0,0,0,0};
        int goal=0;
        System.out.println(numSubarraysWithSum(nums,goal));
    }


    public static int numSubarraysWithSum(int[] nums, int goal) {

        int subArrayNumber = 0;
        for (int i = 0; i < nums.length; i++) { //window sizes
            System.out.println("Window size is: "+i);
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + nums[j];
            }
            if (sum == goal && goal!=0) subArrayNumber++;
            for (int k = i; k < nums.length; k++) {
                sum = sum + nums[k] - nums[k - i];
                if (sum == goal) subArrayNumber++;
            }
        }
        return subArrayNumber;
    }
}
