class Solution {
    public int myAtoi(String s) {
        s =s.trim();
        boolean neg = false;
        int start =0;
        int n = s.length();
        if(n==0) return 0;
        if(s.charAt(0)=='-') {
            neg = true;
            start = 1;
        }else if(s.charAt(0) == '+'){
            start = 1;
        }
        long rev= 0;
        while(start<n){
            char c = s.charAt(start);
            if(Character.isDigit(c)){
            rev=(rev*10)+(c-'0');
            }else break;
            if(neg && -rev <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(!neg && rev >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            start++;
        }


        if(neg) return(int) -rev;
        return (int)rev;
    }
}