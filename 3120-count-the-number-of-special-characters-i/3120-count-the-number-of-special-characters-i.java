class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0 ;
        int[] freq = new int[58];
        for(int i = 0 ; i<word.length(); i++){
            char ch = word.charAt(i);
            freq[ch-'A']++;
        }
        for(int i = 0 ; i<58; i++){
             if ((i >= 0 && i <= 25) && freq[i] > 0 &&freq[i + 32] > 0){
                count++;
            }
        }
        return count ;
    }
}