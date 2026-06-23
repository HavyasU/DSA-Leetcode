class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        long res = 0;
        boolean isNeg = false;
        isNeg = s.charAt(0) == '-';
        int i = (isNeg || s.charAt(0) == '+' )? 1:0;
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                res = res*10 + (int)(c-'0');
            }
            else break;
            if(isNeg && -res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(!isNeg && res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        if(isNeg){
            return (int)-res;
        }

        return (int)res;
    }
}