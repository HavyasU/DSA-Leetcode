class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int need = 0;
        int available = 0;
        int satisfy = 0;

        int slen = s.length;
        int glen = g.length;

        while(available<slen && need < glen){
            
            if(g[need]<=s[available]){
                satisfy++;
                available++;
                need++;
            }else{
                available++;
            }
        }

        return satisfy;
        
    }
}

