class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : licensePlate.toCharArray()){
            c = Character.toLowerCase(c);
            if(c>='a' && c<='z'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        String res = "";
        int mincount = Integer.MIN_VALUE;
        for(String word : words){
            HashMap<Character,Integer> wordmap = new HashMap<>();
            for(char c : word.toCharArray()){
                c = Character.toLowerCase(c);
                if(c>='a' && c<='z'){
                    wordmap.put(c,wordmap.getOrDefault(c,0)+1);
                }
            }
            int count = 0;
            for(char c : wordmap.keySet()){
                if(map.containsKey(c)){
                  count+=Math.min(map.get(c),wordmap.get(c));
                }
            }
            if(mincount<count || (mincount==count && word.length() <  res.length())){
                    mincount = count;
                    res = word;
            }
        }
        return res;
    }
}