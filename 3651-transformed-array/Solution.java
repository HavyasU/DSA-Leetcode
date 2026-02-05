class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int res[] =  new int[nums.length];
        int steps;
        int n = nums.length;

        for(int i=0;i<n;i++){
            int ind = (i+(nums[i]));
            ind = ind%n;
            if(ind<0){
                ind = n+ind;
            }
            res[i] = nums[ind];
        }
        return res;
    }
}