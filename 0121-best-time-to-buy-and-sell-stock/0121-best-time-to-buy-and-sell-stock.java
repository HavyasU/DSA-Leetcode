class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bigs[] = new int[n];
        int max = -999;
        int profit=0;
        for(int i=n-1;i>=0;i--){
            bigs[i] = max; 
            if(max<prices[i]){
                max = prices[i];
            }
        }

        for(int i=0;i<n;i++){
            if(bigs[i]>prices[i]){
                if(profit<(bigs[i]-prices[i])){
                    profit = bigs[i]-prices[i];
                }
            }
        }

        return  profit;
    }
}