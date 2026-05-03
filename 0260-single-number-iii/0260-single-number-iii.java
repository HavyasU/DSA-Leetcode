class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i])){
                hs.remove(nums[i]);
            }else{
                hs.add(nums[i]);
            }
        }
        nums = new int[hs.size()];
        int index = 0;
        for(int item : hs){
            nums[index++] = item;
        }
        return nums;
    }
}