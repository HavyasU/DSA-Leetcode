class Solution {
    public boolean hasAllCodes(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(end<n){
            while(end < n && ((end-start)+1)<=k){
                sb.append(s.charAt(end));
                end++;
            }
            if((end-start)==k)
                set.add(sb.toString());
            sb.setLength(0);

            if(start<n){
                start++;
                end = start;
            }
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