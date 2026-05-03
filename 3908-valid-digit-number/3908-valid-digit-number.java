class Solution {
    public boolean validDigit(int n, int x) {
        boolean isValid = false;
        int lastD = 0;
        while(n>0){
            lastD = n%10;
            if(lastD==x){
                isValid = true;
            }
            n=n/10;
        }

        if(lastD==x){
            isValid = false;
        }

        return isValid;
    }
}