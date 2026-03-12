class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder str = new StringBuilder(s);
        int n = s.length();
        int start = 0;
        int end = n-1;

        while(start<end){
            while((start<end) && !Character.isLetter(str.charAt(start))){
                start++;
            }
            while((start<end) && !Character.isLetter(str.charAt(end))){
                end--;
            }
            char temp = str.charAt(end);
            str.setCharAt(end,str.charAt(start));
            str.setCharAt(start,temp);
            start++;
            end--;
        }

        return str.toString();
    }
}