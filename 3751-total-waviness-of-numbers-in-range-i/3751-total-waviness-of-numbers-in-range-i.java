class Solution {
    public int totalWaviness(int num1, int num2) {
        String cur = Integer.toString(num1);
        int count = 0;
        while(true){
            if(Integer.valueOf(cur) > num2) break;
            for(int i=1;i<cur.length()-1;i++){
                int prev = cur.charAt(i-1);
                int pres = cur.charAt(i);
                int next = cur.charAt(i+1);

                if(prev > pres && next>pres){
                    count++;
                }

                if(pres > prev && pres>next){
                    count++;
                }
            }
            cur = Integer.valueOf(cur)+1 + "";
        }
        return count;
    }
}