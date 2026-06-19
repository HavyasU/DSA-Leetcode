class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int samelen = 0;
        Arrays.sort(suits);
        Arrays.sort(ranks);
        int count = 1;
        int max=0;
        for(int i=1;i<suits.length;i++){
            if(suits[i] == suits[i-1])
            {
                count++;
            }else{
                count = 1;
            }
            max = Math.max(max,count);
        }

        if(max == 5) return "Flush";
        max = 0;
        count = 1;
        for(int i=1;i<ranks.length;i++){
            if(ranks[i] == ranks[i-1])
            {
                count++;
            }else{
                count = 1;
            }
            max = Math.max(max,count);
        }
        if(max >=3) return "Three of a Kind";
        else if(max==2) return "Pair";



        return "High Card";
    }
}