class Solution {
    public int smallestEvenMultiple(int n) {
        while(n>0){
            if(n%2==0) return n;
            n=n*2;
        }
        return -1;
    }
}