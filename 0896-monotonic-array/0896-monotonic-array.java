class Solution {
    public boolean isMonotonic(int[] nums) {
      boolean isMonoInc = true;
      boolean isMonoDec = true;
      int n = nums.length;
      for(int i=1;i<n;i++){
        if(nums[i]<nums[i-1]){
            isMonoInc = false;
        }

        if(nums[i]>nums[i-1]){
            isMonoDec = false;
        }
      }  
      return isMonoInc || isMonoDec;
    }
}