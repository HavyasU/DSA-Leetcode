class Solution {
    public List<String> removeAnagrams(String[] words) {
        char prev[] =null;
        List<String> lst = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char cur[] = words[i].toCharArray();
            Arrays.sort(cur);
            if(prev!=null && Arrays.equals(prev,cur)){
                words[i] = "";
            }else{
                prev = words[i].toCharArray();
                Arrays.sort(prev);
            }
        }

        for(String word : words){
            if(word!="")
            lst.add(word);
        }

        return  lst;
    }
}