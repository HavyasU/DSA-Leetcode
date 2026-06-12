class Solution {
    public boolean checkOnesSegment(String s) {
        boolean firstZero = false;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                firstZero=true;
            }
            if(firstZero && s.charAt(i)=='1'){
                return false;
            }
        }

        return true;
        
    }
}