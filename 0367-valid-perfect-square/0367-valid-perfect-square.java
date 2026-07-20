class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<=0){
            return false;
        }
        int n=num/2;
        if(num==1){
            return true;
        }
        for(int i=1;i<=n;i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }
}