class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        int end = 0;
        int sn = s.length();
        int pn = p.length();

        int parr[] = new int[26];
        for(char c : p.toCharArray()) parr[c-'a']++;

        int freq[] = new int[26];
        List<Integer> lst = new ArrayList<>();

        while(start<sn && end <sn){
            while((end-start+1)>pn){
                freq[s.charAt(start++)-'a']--;
            }

            freq[s.charAt(end)-'a']++;
            if((end-start+1) == pn){
                if(Arrays.equals(freq,parr)){
                    lst.add(start);
                }
            }
            end++;
        }

        return lst;
    }
}