class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count =0;
        int start = 0;
        int end = 0;
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();

        while(end<n || start<n){
            end = start;
            while(end<n && sb.indexOf(s.charAt(end)+"")<0){
                sb.append(s.charAt(end));
                end++;
            }
            if(sb.length() > count){
                count = sb.length();
                System.out.println(sb.toString());
            }
            
            sb.setLength(0);
            start++;
        }

        return count;
    }
}