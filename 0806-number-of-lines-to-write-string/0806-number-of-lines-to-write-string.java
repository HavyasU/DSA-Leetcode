class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        if(s.length() == 0) return new int[]{};
        int lastlen = 0;
        int line = 1;
        int count = 0;
        for(char c : s.toCharArray()){
            int cur = widths[c-'a'];
            if(cur+count <= 100){
                count+=cur;
            }else{
                lastlen = 0;
                count = cur;
                line++;
            }
            lastlen+=cur;
        }

        return new int[] {line, lastlen};
    }
}