class Solution {
    public boolean isGood(int[] nums) {
       Arrays.sort(nums);
       int n = nums[nums.length-1];
       if(nums.length<=1 || nums[nums.length-2]!=n) return false;
       for(int i=0;i<nums.length-1;i++){
        if(nums.length-2 == i){
            if(nums[i]!=n){
                return false;
            }
        }
        if(nums[i] != i+1){
            return false;
        }
       }
       return true;
    }
}