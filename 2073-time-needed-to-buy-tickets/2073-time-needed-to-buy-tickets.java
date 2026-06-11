class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        for(int i=0;;i=(i+1)%n){
            
            if(tickets[i]!=0){
                tickets[i]--;
                time++;
            }
            if(i==k && tickets[i] == 0){
                return time;
            }
        }
    }
}