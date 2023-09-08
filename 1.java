import java.util.Arrays;

class Solution {
    static public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = n-1; i >= 0; i--){
            int j = 1;
            if(nums[i] != 0){
                nums[j-1] = nums[i];
                j++;
            }else{
                int temp = nums[n-1];
                nums[n-1] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,2,5,3};
        System.out.println("hello");
        moveZeroes(arr);
        System.out.print(Arrays.toString(arr));
        
    }
}