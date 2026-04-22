class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum =0;
        int leftSum = 0;
        int rightSum = 0;

        for(int i=0;i<k;i++) leftSum+=cardPoints[i];
        maxSum = leftSum;

        int rindex = cardPoints.length -1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rindex];
            rindex--;

            maxSum = Math.max(maxSum,rightSum+leftSum);
        }

        return maxSum;
    }
}