class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            prefix[i] = sum;
        }

        sum = 0;
        for(int i=0;i<n;i++){
            int start = Math.max(0,i-nums[i]);
            if(start==0){
                sum+=prefix[i];
            }else{
                sum+=(prefix[i] - prefix[start-1]);
            }
        }

        return sum;

    }
}