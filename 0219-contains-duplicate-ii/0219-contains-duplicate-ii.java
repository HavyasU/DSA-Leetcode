class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int ind = map.get(nums[i]);
                if(Math.abs(i-ind) <= k){
                    return true;
                }
            }
                map.put(nums[i],i);
            
        }

        return false;
    }
}