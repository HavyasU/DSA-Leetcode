class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int maxpoint = 0;
        int lastpoint = 0;
        for(int i=0;i<n;i++){
            int cur = lastpoint+gain[i];
            if(cur>maxpoint){
                maxpoint = cur;
            }
            lastpoint =cur;
        }
        return maxpoint;
    }
}


    // -5      1       5       0       -7
// 0   -5,     -4,     1,      1       