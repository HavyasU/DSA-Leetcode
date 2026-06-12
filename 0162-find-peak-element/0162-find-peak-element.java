class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return 0;
        for(int i=0;i<n;i++){
            if((i==0 && nums[i]>nums[i+1]) || (i==n-1 && nums[i]> nums[i-1])){
                return i;
            }
            if(nums[i]> nums[i+1] && nums[i]>nums[i-1]){
                return i;
            }
        }
        return -1;
    }
}