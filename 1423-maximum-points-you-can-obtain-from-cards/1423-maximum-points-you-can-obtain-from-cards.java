class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum =0;
        int sum=0;

        for(int i=0;i<k;i++) sum+=cardPoints[i];
        maxSum = sum;

        int rindex = cardPoints.length -1;
        for(int i=k-1;i>=0;i--){
            sum-=cardPoints[i];
            sum+=cardPoints[rindex];
            rindex--;

            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }
}