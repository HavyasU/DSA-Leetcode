class Solution {
    public int maxSubArray(int[] nums) {
        int sum  = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int ele : nums){
            sum+=ele;
            if(sum>maxsum) maxsum = sum; 
            if(sum < 0){
                sum=0;
            }
        }

        return maxsum;
    }
}