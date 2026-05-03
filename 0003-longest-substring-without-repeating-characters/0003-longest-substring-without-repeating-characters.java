class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap map = new HashMap<>();

        int longLen = 0;

        int left=0;
        int right = 0;
        int len = 0;

        while(right<s.length()){
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if(!map.containsKey(cRight)){
                map.put(cRight,1);
                len++;
                right++;
                if(len > longLen) longLen = len;
            }else{
                map.remove(cLeft);
                left++;
                len--;
            }
        }

        return longLen;

    }
}