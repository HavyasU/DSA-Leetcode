class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean freq[] = new boolean[26];

        for(char c : sentence.toCharArray())
            freq[c-'a'] =true;
        
        boolean panagram = true;
        for(boolean p : freq)
            if(!p) panagram = false;
        
        return panagram;
    }
}