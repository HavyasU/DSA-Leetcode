class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;

        for(Character s : moves.toCharArray()){
            if(s=='U'){
                y++;
            }else if (s=='D'){
                y--;
            }else if (s=='L'){
                x--;
            }else if(s=='R'){
                x++;
            }
        }

        return x==0 && y==0;

    }
}