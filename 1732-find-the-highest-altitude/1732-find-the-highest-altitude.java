class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int sum = 0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=gain[i];
            if(sum>max) max=sum;
        }
        return max;
    }
}


    // -5      1       5       0       -7
// 0   -5,     -4,     1,      1       