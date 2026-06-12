class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int n =  items.size();

        for(int i=0;i<n;i++){
               int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
               if(items.get(i).get(index).equals(ruleValue)){
                count++;
               }
        }
        return count;
    }
}