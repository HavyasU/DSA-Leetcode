class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int val=0;
        int x = 1;
        int sum = 0;
        int i=0;
        while(i<1000){
            val = Math.abs(n-x);
            if(val<=k && (n & x) == 0){
                sum+=x;
            }
            x++;
            i++;
        }

        return sum;
    }
}