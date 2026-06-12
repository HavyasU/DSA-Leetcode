class Solution {
    public int numberOfSpecialChars(String word) {
        int upper[] =  new int[26];
        int lower[] = new int[26];
        
        for(char c : word.toCharArray()){
            if(c>='a' && c<='z'){
                lower[c-'a']++;
            }else if(c>='A' && c<='Z'){
                upper[c-'A']++;
            }
        }
        
        int count = 0;
        for(int i=0;i<26;i++){
            if(lower[i]>0 && upper[i]>0){
                count++;
            }
        }
        return count;
    }
}