class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        int ch = Character.toLowerCase(s.charAt(0));
        for(Character c: s.toCharArray()){
            if(Character.toLowerCase(c) != ch){
                count++;
                ch = Character.toLowerCase(c);
            }
        }

        return count;
    }
}