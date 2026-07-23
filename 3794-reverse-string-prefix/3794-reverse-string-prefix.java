class Solution {
    public String reversePrefix(String s, int k) {
        char str[] = s.toCharArray();
        for(int i=0;i<k/2;i++){
            char c = str[i];
            str[i] = str[k-i-1];
            str[k-i-1]=c;
        }
        return new String(str);
    }
}