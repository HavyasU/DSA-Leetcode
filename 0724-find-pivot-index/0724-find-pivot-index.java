class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        int leftsum = 0;
        int rightsum = 0;
        for(int i=0;i<n;i++){
            
            prefix[i] = leftsum;
            suffix[n-i-1] = rightsum;
            leftsum+=nums[i];
            rightsum+=nums[n-1-i];
        }
        if(suffix[0]==0) return 0;
        for(int i=1;i<n-1;i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        if(prefix[n-1]==0) return n-1;

        return -1;

    }
}