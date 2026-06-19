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
        for(int i=0;i<n;i++){
            if(i==0){
                if(suffix[i]==0) return i;
            }
            if(i==n-1){
                if(prefix[i] == 0) return i;
            }

            if(prefix[i] == suffix[i]){
                return i;
            }
        }

        return -1;

    }
}