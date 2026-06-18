class Solution {
    public void sortColors(int[] nums) {
        int pos=0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int t = nums[pos];
                nums[pos++] = nums[i];
                nums[i] = t;
            }
        }
        for(int i=pos;i<n;i++){
            if(nums[i]==1){
                int t = nums[pos];
                nums[pos++] = nums[i];
                nums[i] = t;
            }
        }
    }
}