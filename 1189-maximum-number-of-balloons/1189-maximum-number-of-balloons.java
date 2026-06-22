class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : text.toCharArray()){
            if(c=='b' || c=='l' || c=='a' || c=='o' || c=='n')
            map.put(c,map.getOrDefault(c,0)+1);
        }

        map.put('b',map.getOrDefault('b',0));
        map.put('a',map.getOrDefault('a',0));
        map.put('l',map.getOrDefault('l',0)/2);
        map.put('o',map.getOrDefault('o',0)/2);
        map.put('n',map.getOrDefault('n',0));

        int min = 999999;
        for(int val : map.values()){
            min = Math.min(min,val);
        }
        return min;
    }
}