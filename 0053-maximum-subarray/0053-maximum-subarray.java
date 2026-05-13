class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==1){
            return nums[0];
        }
        int maxsum=nums[0];
        int sum =nums[0];

        for(int i=1;i<nums.length;i++){
            int ele = nums[i];
            if(ele >= (sum+ele)){
                sum = ele;
            }else{
                sum+=ele;
            }
            if(sum>maxsum)
                maxsum = sum;
        }

        return maxsum;
    }
}