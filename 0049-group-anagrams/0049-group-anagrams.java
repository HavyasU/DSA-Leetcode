class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>  map = new HashMap<>();

        for(String s : strs)
        {
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String st = Arrays.toString(c);
            if(map.containsKey(st)){
                map.get(st).add(s);
            }else{
                map.put(st, new ArrayList<>(List.of(s)));
            }
        } 

        List<List<String>> lst = new ArrayList<>();
        for(List<String> item : map.values()){
            lst.add(item);
        }
        return lst;
    }
}

