class Solution {
    public int compress(char[] chars) {
       int idx = 0;
       int count = 1;
       for(int i=0;i<chars.length;i++){
        if(i==0 || chars[i]!=chars[i-1]){
            if(count>1){
                  for(char c : Integer.toString(count).toCharArray()){
                    chars[idx++]=c;
                    }
                    count = 1;
            }
            chars[idx++] = chars[i];
        }else{
            count++;
        }
       }
       if(count>1){
              for(char c : Integer.toString(count).toCharArray()){
                    chars[idx++]=c;
                }
        }
       return idx;
    }
       
}