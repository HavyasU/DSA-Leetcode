class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int items[] = new int[n];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < pivot)
            items[idx++] = nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i] == pivot)
            items[idx++] = nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i] > pivot)
            items[idx++] = nums[i];
        }

        return items;
    }
}