class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=1;
        int counter = nums[0];
        while(i<n){
            if(nums[i] <= counter){
                int j=i+1;
                while(j<n && nums[j]<=counter){
                    j++;
                }
                if(j==n){
                    return i;
                }
                nums[i] = nums[j];
            }
            counter = nums[i];
            i++;
        }
        return i;
    }
}