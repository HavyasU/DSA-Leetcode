class Solution {
    public String[] findWords(String[] words) {
        List<String> lst = new ArrayList<>();
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        String Original = String.join(":",words)+":";
        String merged = Original.toLowerCase();
        int latestPoint = 0;
        int valid1 = 0;
        int valid2 = 0;
        int valid3 = 0;
        
        for(int i=0;i<merged.length();i++){
            char c = merged.charAt(i);
            if(c==':'){
                int len = i-latestPoint;
                if(valid1 == len || valid2==len || valid3==len){
                    lst.add(Original.substring(latestPoint,i));
                }
                latestPoint = i+1; 
                valid1=0;
                valid2=0;
                valid3=0;
            }else{
            if(firstRow.indexOf(c)!=-1) valid1++;
            if(secondRow.indexOf(c)!=-1) valid2++;
            if(thirdRow.indexOf(c)!=-1) valid3++;
            }
           
        }
       
        

        return lst.toArray(new String[0]);
    }
}