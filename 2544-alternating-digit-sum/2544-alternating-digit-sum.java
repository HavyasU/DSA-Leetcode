class Solution {
    public int alternateDigitSum(int n) {
        String num = String.valueOf(n);
        int count = 0;
        int sum = 0;
        for(char c : num.toCharArray()){
            count++;
            if(count%2==0){
                sum+=(-(c-'0'));
            }else{
                sum+=(c-'0');
            }
        }
        return sum;
    }
}