class Solution {
    public int[] twoSum(int[] nums, int target) {
        int  n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int req = target - nums[i];
            if(map.containsKey(req)){
                return new int[] {i,map.get(req)};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}