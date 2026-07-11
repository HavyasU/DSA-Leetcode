class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length <2)  return 0;
        if(nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }
        int diff = 0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            int abs = Math.abs(nums[i] - nums[i-1]);
            if(diff < abs){
                diff = abs;
            }
        }

        return diff;
    }
}