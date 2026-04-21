class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder longest = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.setLength(0);
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                boolean isNice = true;
                String currentStr = sb.toString();
                for(int k=0;k<sb.length();k++){
                    char toggled;
                    char cur = sb.charAt(k);
                    if(cur>='A' && cur<='Z'){
                        toggled = Character.toLowerCase(cur);
                    }else{
                        toggled = Character.toUpperCase(cur);
                    }
                    if(!currentStr.contains(toggled+"")){    
                        isNice = false;
                        
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