class Solution {
    public int maxNumberOfBalloons(String text) {
        String word = "balon";
        int freq[] = new int[5];
        for(char c : text.toCharArray()){
            int ind = word.indexOf(c);
            if(ind >= 0 && ind < 5){
                freq[ind]++;
            }
        }
        freq[2]/=2;
        freq[3]/=2;
        int min = 999999;
        for(int i=0;i<5;i++){
            System.out.println(freq[i]);
            min = Math.min(min,freq[i]);
        }
        return min;
    }
}