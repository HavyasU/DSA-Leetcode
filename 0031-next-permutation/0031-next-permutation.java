class Solution {
    public void nextPermutation(int[] nums) {
        
        int breakpoint = -1;
        int n = nums.length;

        // find breakpoint 
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                breakpoint = i;
                break;
            }
        }

        if(breakpoint == -1){
            Arrays.sort(nums);
            return;
        }

        //swap it with next smallest element that is greater than breakpoint
        int minind = breakpoint+1;
        for(int i=breakpoint+1;i<n;i++){
            if(nums[i] > nums[breakpoint]){
                if(nums[i] < nums[minind]){
                    minind = i;
                }
            }
        }
        int temp = nums[minind];
        nums[minind] = nums[breakpoint];
        nums[breakpoint] = temp;

        // sort elemets after the breakpoint  to create a smaller value
        Arrays.sort(nums,breakpoint+1,n);

    }
}