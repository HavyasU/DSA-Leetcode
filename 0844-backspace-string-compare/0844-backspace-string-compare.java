class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stks = new Stack<>();
        Stack<Character> stkt = new Stack<>();

        for(int i=0;i<s.length();i++){
            char sele = s.charAt(i);
            if(sele=='#'){
                if(!stks.isEmpty())stks.pop();
            }else{
                stks.push(sele);
            }
        }

         for(int i=0;i<t.length();i++){
            char tele = t.charAt(i);
            
            if(tele=='#'){
                if(!stkt.isEmpty())stkt.pop();
            }else{
                stkt.push(tele);
            }
        }

        if(stks.size()!=stkt.size()) return false;
        for(int i=0;i<stks.size();i++){
            if(stks.get(i)!=stkt.get(i)){
                return false;
            }
        }

        return true;

    }
}