class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int nearest = nums[0]+nums[1]+nums[2];
        if(n==3){
            return nearest;
        }

        for(int i=0;i<n-2;i++){
            int ele = nums[i];
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(Math.abs(target-sum) < Math.abs(target-nearest)){
                    nearest = sum;
                }
                
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                    left++;
                }
            }
            
        }

        return nearest;
    }
}



//   -1, 2, 1, -4
//   -4, -1, 1, 2   sorted
//   
// 