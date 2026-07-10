class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for(int ele : nums){
            if(ele == num){
                num++;
            }
        }

        return num;
    }
}