class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int samelen = 0;
        Arrays.sort(suits);
        Arrays.sort(ranks);
        int suitcount = 1;
        int rankcount = 1;
        int suitmax=0;
        int rankmax=0;
        for(int i=1;i<suits.length;i++){
            if(suits[i] == suits[i-1])
            {
                suitcount++;
            }else{
                suitcount = 1;
            }
            if(ranks[i] == ranks[i-1])
            {
                rankcount++;
            }else{
                rankcount = 1;
            }
            suitmax = Math.max(suitmax,suitcount);
            rankmax = Math.max(rankmax,rankcount);
        }

        if(suitmax == 5) return "Flush";
        else if(rankmax >=3) return "Three of a Kind";
        else if(rankmax==2) return "Pair";
        return "High Card";
    }
}