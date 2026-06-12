class Solution {
    public String[] findWords(String[] words) {
        List<String> lst = new ArrayList<>();
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        String merged = String.join(":",words)+":";
        System.out.println(merged);
        int latestPoint = 0;
        int valid1 = 0;
        int valid2 = 0;
        int valid3 = 0;
        for(int i=0;i<merged.length();i++){
            char c = merged.toLowerCase().charAt(i);
            if(c==':'){
                int len = i-latestPoint;
                if(valid1 == len || valid2==len || valid3==len){
                    lst.add(merged.substring(latestPoint,i));
                }
                latestPoint = i+1; 
                valid1=0;
                valid2=0;
                valid3=0;
            }else{
            if(firstRow.contains(c+"")) valid1++;
            if(secondRow.contains(c+"")) valid2++;
            if(thirdRow.contains(c+"")) valid3++;
            }
           
        }
       
        

        return lst.toArray(new String[0]);
    }
}