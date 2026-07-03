class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int fir =0;
        int sec = 0;
        StringBuilder sb = new StringBuilder();
        while(fir < len1 && sec < len2){
            sb.append(word1.charAt(fir++));
            sb.append(word2.charAt(sec++));
        }

        while(fir < len1 ){
            sb.append(word1.charAt(fir++));
        }
        while(sec < len2 ){
            sb.append(word2.charAt(sec++));
        }

        return sb.toString();
    }
}