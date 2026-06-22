class Solution {
    public int maxSubArray(int[] nums) {
        int sum  = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int ele : nums){
            if(sum < 0){
                sum=ele;
            }else
            sum+=ele;
            if(sum>maxsum) maxsum = sum; 
           
        }

        return maxsum;
    }
}