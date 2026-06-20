class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>  map = new HashMap<>();

        for(String s : strs)
        {
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String st = Arrays.toString(c);
            List<String> list = map.getOrDefault(st, new ArrayList<>());
            list.add(s);
            map.put(st, list);
        } 

        List<List<String>> lst = new ArrayList<>();
        for(List<String> item : map.values()){
            lst.add(item);
        }
        return lst;
    }
}

