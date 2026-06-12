class Solution {
    public int furthestDistanceFromOrigin(String moves) {
         int l=0,r=0,s=0;
        int val = 0;
         for(char c: moves.toCharArray()){
            if(c=='L') l++;
            if(c=='R') r++;
            if(c=='_') s++;
            
         }

         
        if(l>=r){
            val = l-r;
        }else{
            val = r-l;
        }
        return val+s;
    }
}

