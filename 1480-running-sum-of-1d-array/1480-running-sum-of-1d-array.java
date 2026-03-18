class Solution {
    public int[] runningSum(int[] nums) {
        int[] lst = new int[nums.length];

        int sum = 0;
        for(int i=0;i<lst.length;i++){
            sum+=nums[i];
            lst[i] = sum;
        }

        return lst;
    }
}