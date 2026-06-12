class Solution {

    public int binarySearch(int[] nums, int start, int end,int target, String dir){
        if(start > end) return -1;
        int res = -1;
        int n  = nums.length-1;
            int mid = (start+end)/2;
            if(nums[mid]==target){
                res = mid;
               
    if(dir.equals("left")){
        int left = binarySearch(nums, start, mid - 1, target, dir);
        return (left != -1) ? left : res;
    } else {
        int right = binarySearch(nums, mid + 1, end, target, dir);
        return (right != -1) ? right : res;
    }
            }else if(nums[mid] > target){
                int left = binarySearch(nums,start,mid-1,target,dir);
                res = left==-1 ? res : left;
            }else if(nums[mid] < target){
                int right = binarySearch(nums,mid+1,end,target,dir);
                res = right == -1 ? res : right;
            }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums,0,nums.length-1,target,"left");
        res[1] = binarySearch(nums,0,nums.length-1,target,"right");
        return res;
    }
}