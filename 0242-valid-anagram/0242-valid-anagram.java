class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
       char[] schars = s.toCharArray();
       char[] tchars = t.toCharArray();

       Arrays.sort(tchars);
       Arrays.sort(schars);
        int n  = s.length();
        for(int i=0;i<n;i++){
            if(tchars[i]!=schars[i]) return false;
        }

        return true;

 
    }
}