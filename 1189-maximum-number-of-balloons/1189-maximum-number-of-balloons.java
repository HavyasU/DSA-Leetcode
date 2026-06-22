class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0, a=0, l=0, o=0, n=0;

        for(char c : text.toCharArray()){
            if(c=='b') b++;
            else if(c=='a') a++;
            else if(c=='l') l++;
            else if(c=='o') o++;
            else if(c=='n') n++;
        }

        l/=2;
        o/=2;

        int min = b;
        int ar[] = {b,a,l,o,n};
        for(int i=0;i<ar.length;i++){
            if(ar[i]<min) min = ar[i];
        }

        return min;

    }
}