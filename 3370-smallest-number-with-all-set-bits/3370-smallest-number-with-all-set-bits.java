class Solution {
    public int smallestNumber(int n) {
        while(true){
            String bin = Integer.toBinaryString(n);
            boolean setbit = true;
            for(char c : bin.toCharArray()){
                if(c=='0'){
                    setbit=false;
                }
            }
            if(setbit){
                return n;
            }
            n=n+1;
        }
    }
}