class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[58];
        for(char c:s.toCharArray()){
            freq[c-'A']++;
        }
        int count=0;
        for(int i=0;i<freq.length;i++){
            int val = freq[i];
           if(val%2==0){
            count+=val;
           }else{
            if(count%2==0){
                count+=val;
            }else{
                count+=val-1;
            }
           }
        }
        return count;
    }
}