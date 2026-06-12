class Solution {
    public int mirrorDistance(int n) {
        int rev=0;
        int num = n;
        while(n!=0){
            rev=(rev*10)+(n%10);
            n=n/10;
        }
        // System.out.println(rev);
        return Math.abs((rev-num));
    }
}