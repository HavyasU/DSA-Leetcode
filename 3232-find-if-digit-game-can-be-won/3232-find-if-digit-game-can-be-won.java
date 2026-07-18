class Solution {
    public boolean canAliceWin(int[] nums) {
        int singlesum  = 0;
        int doublesum  = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>9){
                doublesum+=nums[i];
            }else{
                singlesum+=nums[i];
            }
        }
        return !(singlesum == doublesum);
    }
}