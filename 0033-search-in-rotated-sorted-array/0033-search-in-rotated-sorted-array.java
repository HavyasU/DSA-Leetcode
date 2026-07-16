class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = -1;

        while(low<=high){
            mid = low+(high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[low] <= nums[mid]) { // Left half is sorted

                if (target >= nums[low] && target < nums[mid]) {

                    high = mid - 1; // Target is in the left half

                } else {

                    low = mid + 1;  // Target is in the right half

                }
            }else{
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Target is in the left half
                } else {
                    high = mid - 1;  // Target is in the right half
                }
            }
        }

        return -1;
    }
}

// [4,5,6,7,0,1,2]
// target = 0


// [0,1,2,3,4,5,6] -- index
// [4,5,6,7,0,1,2] -- ele


// 0+6 = 3
// 7 !=


// 4>7 false
// 7>2 true

// low = 4 , high = 6
// 10/2 = 5 (mid)
// 1!=0
// 0>1 false;

