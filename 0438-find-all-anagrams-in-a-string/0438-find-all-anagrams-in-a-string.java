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

        for(int i=0;i<sn-pn+1;i++){
            for(int j=0;j<pn;j++){
                freq[s.charAt(i+j)-'a']++;
            }
            if(Arrays.equals(freq,parr)){
                lst.add(i);
            }
            freq = new int[26];
        }

        return lst;
    }
}