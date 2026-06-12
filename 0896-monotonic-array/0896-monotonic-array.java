class Solution {
    public boolean isMonotonic(int[] nums) {
      int n = nums.length;
      for(int i=1;i<n;i++){
        if(nums[i]<nums[i-1]){
            return false;
        }

        if(nums[i]>nums[i-1]){
            return false;
        }
      }  
      return true;
    }
}