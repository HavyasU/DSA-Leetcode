class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        StringBuilder longest = new StringBuilder();
        for(int i=0;i<n;i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(s.charAt(j));
                boolean isNice = true;
                for(int k=i;k<=j;k++){
                    Character lower = Character.toLowerCase(s.charAt(k));
                    Character upper = Character.toUpperCase(s.charAt(k));
                   if(!hs.contains(lower) || !hs.contains(upper)){
                    isNice = false;
                    break;
                   }
                }
                if(isNice){
                    if((j - i + 1) > longest.length() ){
                        longest = new StringBuilder(s.substring(i,j+1));
                    }
                }
                
            }
        }

        return longest.toString();
    }
}