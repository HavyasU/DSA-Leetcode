class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int count = 0;
        for(String str : text.split(" ")){
            for(Character c:brokenLetters.toCharArray()){
                if(str.contains(String.valueOf(c))){
                    count++;
                    break;
                }
            }
        }

        return text.split(" ").length - count;
    }
}