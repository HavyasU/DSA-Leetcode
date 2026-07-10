class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : nums){
            hs.add(ele);
        }

        int num = 1;
        while(true){
            if(!hs.contains(num)){
                return num;
            }
            num++;
        }
        
    }
}