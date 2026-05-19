class Solution {
    public int primePalindrome(int n) {
        boolean stoploop = false;
        int small[] = {2,3,5,7,11};
        for(int x:small){
            if(x>=n){
                return x;
            }
        }

        for(int i = 10;i<100000;i++){
            String rev = new StringBuilder(i+"").reverse().substring(1);
            int pal = Integer.parseInt(i+""+rev);
            if(isPrime(pal) && pal>=n){
                return pal;
            }
        }

        return -1;
    }

    public static boolean isPrime(int pal)
    {
        boolean prime = true;
        for(int i=2;i<=Math.sqrt(pal);i++){
            if(pal%i==0){
               prime = false;
               break;
            }
        }
    return prime;
    }
}