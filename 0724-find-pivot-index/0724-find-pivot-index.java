class Solution {
    public int pivotIndex(int[] nums) {
        int leftsum[] = new int[nums.length];
        int rightsum[] = new int[nums.length];
        int n = nums.length;
        leftsum[0] = 0;
        rightsum[n-1] = 0;
        for(int i=1;i<n;i++){
            leftsum[i] = leftsum[i-1]+nums[i-1];
            rightsum[n-i-1] = rightsum[n-i]+nums[n-i];
        }
        for(int i=0;i<n;i++){
            if(i==0 && rightsum[i]==0){
                    return i;
            }
            if(i==n-1 && 0==leftsum[i]){
                    return i;
            }
        

            if(leftsum[i] == rightsum[i]){
                return i;
            }

        }
        return -1;
    }
}