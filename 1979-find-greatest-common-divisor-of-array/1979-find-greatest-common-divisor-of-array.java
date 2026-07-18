class Solution {
    public int findGCD(int[] nums) {
        int small=Integer.MAX_VALUE, large = Integer.MIN_VALUE;
        for(int num : nums){
            if(num<small) small = num;
            if(num>large) large = num;

        }
        for(int i=small;i>=1;i--){
            if(small%i==0 && large%i==0){
                return i;
            }
        }
        return 0;
    }
}