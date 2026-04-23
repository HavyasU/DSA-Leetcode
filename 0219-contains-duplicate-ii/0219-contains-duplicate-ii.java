class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
                int ind = map.getOrDefault(nums[i],-99);
                if(ind!=-99 && Math.abs(i-ind) <= k){
                    return true;
                }
                 map.put(nums[i],i);
            
        }

        return false;
    }
}