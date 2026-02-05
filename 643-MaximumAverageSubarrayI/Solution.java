class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum  =0 ;

        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxsum = sum;


        for(int i=k;i<n;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            maxsum = Math.max(sum,maxsum);
        }



    
        return (double) maxsum / (float)k;
    }
}

