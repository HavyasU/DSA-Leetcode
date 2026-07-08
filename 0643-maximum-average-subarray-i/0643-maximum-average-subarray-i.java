class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxsum = 0;
        int n = nums.length;
        double cursum = 0;
        for(int i=0;i<k;i++){
            cursum+=nums[i];
        }
        maxsum = cursum;


        for(int i=0;i<n-k;i++){
            cursum-=nums[i];
            cursum+=nums[i+k];
            if(maxsum < cursum) maxsum = cursum;
        }

        return maxsum/k;
    }
}