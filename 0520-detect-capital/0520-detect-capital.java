class Solution {
    public boolean detectCapitalUse(String word) {
        boolean allcaps = true;
        boolean allsmall = true;
        boolean firstCaps = true;

        for(int i=0;i<word.length();i++){
            boolean isCap = Character.isUpperCase(word.charAt(i));

            if(isCap){
                allsmall = false;
                if(i>0){
                    firstCaps = false;
                }
            }else{
                allcaps = false;
            }            
        }

        return allcaps || allsmall || firstCaps;

    }
}