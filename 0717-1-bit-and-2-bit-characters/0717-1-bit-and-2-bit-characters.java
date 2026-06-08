class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int  n = bits.length;
        for(int i=0;i<n;){
            if(bits[i]==1){
                i+=2;
            }else{
                i+=1;
                if(i==n){
                    return true;
                }
            }
        }
        return false;
    }
}