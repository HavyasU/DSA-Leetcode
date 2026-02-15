class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String str:words){
            int sum=0;
            for(char c:str.toCharArray()){
                sum+=weights[c-'a'];
            }
            sum = (sum%26);
            sb.append((char)('z'-sum));
        }
        return sb.toString();
    }
}