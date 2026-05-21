class Solution {
    public boolean checkRecord(String s) {
        boolean isEligible = true;

        int absent = 0;
        int cons = 0;
        for(char c : s.toCharArray()){
            if(c=='A'){
                absent++;
                if(absent==2){
                    return false;
                }
            }
            if(c=='L') cons++;
            else cons=0;
            if(cons==3) return false;
        }
        return true;

    }
}