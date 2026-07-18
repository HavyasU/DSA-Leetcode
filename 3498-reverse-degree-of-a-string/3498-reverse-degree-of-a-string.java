class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            sum+= ((26) - (int)(s.charAt(i)-'a'))*(i+1);
        }
        return sum;
    }
}