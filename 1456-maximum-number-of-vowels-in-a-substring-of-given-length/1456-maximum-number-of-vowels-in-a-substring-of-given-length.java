class Solution {
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    public int maxVowels(String s, int k) {
        int start=0, end=0;
        int sum=0, maxsum=0;
        int  n = s.length();
        while(start<n && end<n){
            if(isVowel(s.charAt(end))) sum++;
            end++;

            

            if((end-start)>k){
                if(isVowel(s.charAt(start))) sum--;
                start++;
            }

            if((end-start) == k){
                if(sum > maxsum)
                    maxsum = sum;
            }
            
        }
        return maxsum;
    }
}