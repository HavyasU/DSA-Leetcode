class Solution {
    public String reversePrefix(String word, char ch) {
        
        StringBuilder sb = new StringBuilder(word);
        int index = sb.indexOf(ch+"");

        if(index == -1){
            return sb.toString();
        }
        for(int i=0;i<=index/2;i++){
            char c = sb.charAt(index-i);
            sb.setCharAt(index-i, sb.charAt(i));
            sb.setCharAt(i,c);         
        }

        return sb.toString();
    }
}