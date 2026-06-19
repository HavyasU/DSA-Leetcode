class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int samelen = 0;
        Arrays.sort(ranks);

        char s = suits[0];
        if(suits[1] == s && suits[2] == s && suits[3] == s && suits[4] == s) return "Flush";

        int rankcount = 1;
        int rankmax=0;
        for(int i=1;i<suits.length;i++){
            if(ranks[i] == ranks[i-1])
            {
                rankcount++;
            }else{
                rankcount = 1;
            }
            rankmax = Math.max(rankmax,rankcount);
        }

        if(rankmax >=3) return "Three of a Kind";
        else if(rankmax==2) return "Pair";
        return "High Card";
    }
}