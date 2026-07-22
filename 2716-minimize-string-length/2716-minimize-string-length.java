class Solution {
    public int minimizedStringLength(String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        int count=0;
        for(int c : freq){
            if(c!=0) count++;
        }
        return count;
    }
}