class Solution {
    public String greatestLetter(String s) {
        char greater = '\0';
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c) && c>greater && s.contains(String.valueOf(Character.toLowerCase(c)))){
                greater = c;
            }
        }
        if (greater == '\0') {
        return "";
        }
        return String.valueOf(greater);
    }
}