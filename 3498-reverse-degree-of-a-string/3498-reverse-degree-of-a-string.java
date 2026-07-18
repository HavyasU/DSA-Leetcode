class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            sum+= ((int)('z'-'a'+1) - (int)(s.charAt(i)-'a'))*(i+1);
        }
        return sum;
    }
}