class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder longest = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.setLength(0);
            HashSet<Character> hs = new HashSet<>();
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                hs.add(s.charAt(j));
                boolean isNice = true;
                String currentStr = sb.toString();
                for(int k=0;k<sb.length();k++){
                    Character lower = Character.toLowerCase(sb.charAt(k));
                    Character upper = Character.toUpperCase(sb.charAt(k));
                   if(!hs.contains(lower) || !hs.contains(upper)){
                    isNice = false;
                    break;
                   }
                }
                if(isNice){
                    if(sb.length() > longest.length() ){
                        longest = new StringBuilder(sb);
                    }
                }
                
            }
        }

        return longest.toString();
    }
}