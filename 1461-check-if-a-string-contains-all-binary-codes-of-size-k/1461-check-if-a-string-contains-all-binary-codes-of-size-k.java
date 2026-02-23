class Solution {
    public boolean hasAllCodes(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        while(end<n){
            while(end < n && ((end-start)+1)<k){
                end++;
            }
            if(end<n && (end-start+1)==k){
                set.add(s.substring(start,end+1));
            }
            start++;
        }

        for(String ss:set){
            System.out.println(ss);
        }

        if(set.size() == Math.pow(2,k)){
            return true;
        }
        return false;
    }
}