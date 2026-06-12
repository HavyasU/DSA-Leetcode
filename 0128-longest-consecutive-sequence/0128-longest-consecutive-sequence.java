class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        int count = 0;
        
        for(int n:nums){
            set.add(n);
        }
        for(int n:set){
            if(!set.contains(n-1)){
                int start = n;
                int len =1;
                while(set.contains(start+1)){
                    len++;
                    start++;
                }
                longest = Math.max(longest,len);
            }
        }
        return longest;
    }
}