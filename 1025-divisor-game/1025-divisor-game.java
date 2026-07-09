class Solution {
    public boolean divisorGame(int n) {
        boolean isAlice = true;
        int x;
        while(true){
            for(x=1;x<n/2;x++){
                if(n%x == 0){
                    break;
                }
            }

            if(x>(n/2)){
                return !isAlice;
            }

            n = n-x;
            isAlice = !isAlice;
        }
    }
}