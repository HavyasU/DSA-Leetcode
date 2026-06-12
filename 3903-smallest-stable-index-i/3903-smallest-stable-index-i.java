class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max;
        int n = nums.length;
        int min[] = new int[n];
        min[n-1] = nums[n-1];
    
        for(int i=n-2;i>=0;i--){
            if(nums[i]<min[i+1]){
                min[i] = nums[i];
            }else{
                min[i] = min[i+1];
            }
        }

        max = nums[0];
        for(int i=0;i<n;i++){
            if((max-min[i])<=k){
                return i;
            }
            if(nums[i]>max){
                max = nums[i];
            }
        }

        return -1;


    }
}