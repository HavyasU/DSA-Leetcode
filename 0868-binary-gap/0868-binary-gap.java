class Solution {
    public int binaryGap(int n) {
        int first = 0;
        int second = 1;
        String bin = Integer.toBinaryString(n);
        int len = bin.length();
        int max=0;

        while(second<len){
            while(second<len && bin.charAt(second)=='0'){
                second++;
            }

            if(second<len && max<(second-first))
                max = second-first;
            
            first = second;
            second++;
        }
        return max;
    }
}