class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> lst = new ArrayList<Integer>();
        for(int i=0;i< words.length;i++){
            if(words[i].contains(Character.toString(x))){
                lst.add(i);
            }
        }
        return lst;
    }
}