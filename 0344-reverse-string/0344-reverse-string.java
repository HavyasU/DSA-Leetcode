class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while(left<right){
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
        }
    }
}