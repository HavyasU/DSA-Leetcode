class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s+s);


        if(s.length() == goal.length() && sb.indexOf(goal)!=-1){
            return true;
        }else{
            return false;
        }

    }
}