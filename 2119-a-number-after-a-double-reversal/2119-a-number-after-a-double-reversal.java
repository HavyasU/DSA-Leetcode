class Solution {
    public boolean isSameAfterReversals(int num) {
        boolean containsZero = false;
        while(num!=0){
        int d = num%10;
        if(d==0){
            containsZero = true;
        }else if(containsZero){
            return false;
        }else{
            return true;
        }
        num=num/10;
      }  

    return true;
    }
}