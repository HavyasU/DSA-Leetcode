class Solution {
    public boolean isPalindrome(String s,int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        boolean deleted = false;
        int n = s.length();
        int start = 0;
        int end = n-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                    if(!deleted){
                        if(isPalindrome(s,start+1,end)){
                        start++;
                    }else if(isPalindrome(s,start,end-1)){
                        end--;
                    }else{
                        return false;
                    }
                    deleted = true;
                }else{
                    return false;
                }
            }else{
                start++;
                end--;
            }

           
        }
        if(start<end){
            return false;
        }


        return true;

    }
}