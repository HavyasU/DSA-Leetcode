class Solution {
    public long sumAndMultiply(int n) {
        String num = n + "";
        long x = 0;
        long sum = 0;
        for(char c : num.toCharArray()){
            if(c=='0') continue; 
            x = (x*10)+(c-'0');
            sum+=(c-'0');
        }
        return (long)(x*sum);
    }
}