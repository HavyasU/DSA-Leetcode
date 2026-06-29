class Solution {
    public int compress(char[] chars) {
       StringBuilder sb = new StringBuilder();
       char prev = '\0';
       int count = 0;

       for(char c : chars){
        if(prev == c){
            count++;
        }else{
            if(count>1){
                sb.append(count);
            }
            sb.append(c);
            prev=c;
            count=1;
        }
       }
       if(count>1){
                sb.append(count);
        }
       int rn = sb.toString().length();
       for(int i=0;i<rn;i++){   
        chars[i] = sb.charAt(i);
       }
       return rn; 
    }
}