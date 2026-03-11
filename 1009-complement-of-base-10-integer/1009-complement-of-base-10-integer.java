class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        for(int i=0;i<sb.length();i++){
            sb.setCharAt(i,(sb.charAt(i) == '1'?'0':'1'));
        }
        int num = Integer.parseInt(sb.toString(),2);
        return num;
    }
}