class Solution {
    public int getIndex(String ruleKey){
        switch(ruleKey){
            case "type":return 0;
            case "color":return 1;
            case "name":return 2;
        }
        return -1;
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for(int i=0;i<items.size();i++){
               int index = getIndex(ruleKey);
               if(items.get(i).get(index).equals(ruleValue)){
                count++;
               }
        }
        return count;
    }
}