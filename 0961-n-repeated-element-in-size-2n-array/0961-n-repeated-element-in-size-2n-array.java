class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length/2;

        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)==n){
                return key;
            }
        }
        return -1;
    }
}