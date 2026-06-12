class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                if(nums[i]==max && nums[(i+1)%n]==min){
                    min=-1;
                    max=-1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}