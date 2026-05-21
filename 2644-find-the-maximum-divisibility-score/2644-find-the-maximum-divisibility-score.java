class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxcount = 0;
        int divisor = 0;
        for(int i=0;i<divisors.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]%divisors[i] == 0){
                    count++;
                }
            }
            if(count>maxcount){
                divisor = divisors[i];
                maxcount = count;
            }else if(count == maxcount){
                if(divisors[i]<divisor || divisor == 0){
                    divisor = divisors[i];
                }
            }
        }
        return divisor;
    }
}