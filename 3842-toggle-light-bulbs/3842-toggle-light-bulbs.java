class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean bulbStatus[] = new boolean[101];
        for(Integer b:bulbs){
            bulbStatus[b] = bulbStatus[b] == true ? false : true;
        }
        Collections.sort(bulbs);
        for(int i=bulbs.size()-1;i>=0;i--){
            if(!bulbStatus[bulbs.get(i)]){
                bulbs.remove(i);
            }
            else if(i>0 && bulbs.get(i-1) == bulbs.get(i)){
                bulbs.remove(i);
            }
        }
        return bulbs;
    }
}