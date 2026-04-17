class Solution {
    public static void reverse(StringBuilder sb,int l, int r){
        while(l<r){
            char ch = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,ch);
            r--;
            l++;
        }
    }
    public String reverseStr(String s, int k) {
        int left = 0;
        int right = k-1;

        StringBuilder sb = new StringBuilder(s);
        int n = s.length();


        if(n<k){
           reverse(sb,0,n-1);
           return sb.toString(); 
        }

        while(left<n){
            right = Math.min(left+k-1,n-1);
            reverse(sb,left,right);
            left+=k*2;
        }
        return sb.toString();
    }
}