class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        s = s.toUpperCase();
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='-'){
                continue;
            }
            count++;
            sb.append(c);
            if(count==k){
                sb.append('-');
                count=0;
            }
        }
        if(sb.length() > 0 && sb.charAt(sb.length()-1)=='-'){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.reverse().toString();
    }
}