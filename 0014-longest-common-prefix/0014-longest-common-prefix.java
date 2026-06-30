class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev="";
        int j;
        for(int i=0;i<strs.length;i++){
            String word = strs[i];
            if(i==0){
                prev = word;
            }else{
                for(j=0;j<prev.length() && j<word.length();){
                    if(word.charAt(j)==prev.charAt(j)){
                        j++;
                    }else{
                        break;
                    }
                }
                prev = word.substring(0,j);

            }
        }

        return prev;
    }
}