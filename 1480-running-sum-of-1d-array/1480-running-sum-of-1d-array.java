class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                prefix[i] = nums[i];
            }else{
                prefix[i] = prefix[i-1]+nums[i];
            }
        }
        return prefix;
    }
}