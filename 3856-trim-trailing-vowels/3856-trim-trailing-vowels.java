class Solution {
    public String trimTrailingVowels(String s) {
        int n  = s.length();
        char[] chars = s.toCharArray();
        int validlen = chars.length;
        for(int i=validlen-1;i>=0;i--){
            if("aeiou".indexOf(chars[i])!=-1){
                validlen--;
            }else break;
        }
        return new String(chars,0,validlen);
    }
}