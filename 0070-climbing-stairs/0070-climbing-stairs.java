class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int s1 = 1;
        int s2 = 2;
        int cur= 0;
        for(int i=3;i<=n;i++){
            cur = s1+s2;
            s1 = s2;
            s2 = cur;
        }
        return cur;
    }
}