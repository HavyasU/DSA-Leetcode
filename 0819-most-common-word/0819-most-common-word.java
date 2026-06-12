class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase();
        

        HashMap<String,Integer> hm = new HashMap<>();

        for(String word:paragraph.split(" ")){
            if(word.trim()!="" && !Arrays.asList(banned).contains(word.trim())){
                hm.put(word,hm.getOrDefault(word,0)+1);
            }
        }

        int max = Collections.max(hm.values());


        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            if(entry.getValue()==max){
                return entry.getKey();
            }
        }

        return "";

    }
}