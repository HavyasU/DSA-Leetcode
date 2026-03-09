class Solution {
    public int numberOfSpecialChars(String word) {
        int letters[] = new int[52];
        int count = 0;
        for(char c:word.toCharArray()){
            if(Character.isLowerCase(c))
                letters[c-'a']++;
            else
                letters[c-'A'+26]++;
        }

        for(int i=0;i<letters.length/2;i++){
            if(letters[i]>0 && letters[i+26]>0){
                count++;
            }
        }
        return count;
    }
}