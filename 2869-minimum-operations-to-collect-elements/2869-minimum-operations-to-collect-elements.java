class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int reqsum = k*(k+1)/2;
        int sum  = 0;
        int ops=0;
        for(int i=nums.size()-1;i>=0;i--){
            if(set.add(nums.get(i))){
                if(nums.get(i)<=k)
                sum+=nums.get(i);
            }

            ops++;

            if(sum == reqsum){
                return ops;
            }
        }
        return ops;
    }
}