class Solution {
    public static String convert(String str){
            StringBuilder sb = new StringBuilder();
            for(char c : str.toCharArray()){
                sb.append((int)(c-'a'+1)+"");
            }
            return sb.toString();
    }
    public int getLucky(String s, int k) {
        s = convert(s);
        for(int i=0;i<k;i++){
            int sum = 0;
            for(char c : s.toCharArray()){
                sum+=c-'0';
            }
            s = sum+"";
        }
        return Integer.valueOf(s);
    }
}