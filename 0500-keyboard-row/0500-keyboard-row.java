class Solution {
    public String[] findWords(String[] words) {
        List<String> lst = new ArrayList<>();
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        for(String word : words){
            boolean valid1 = true;
            boolean valid2 = true;
            boolean valid3 = true;
            for(char c : word.toLowerCase().toCharArray()){
                if(!firstRow.contains(c+"")) valid1=false;
                if(!secondRow.contains(c+"")) valid2=false;
                if(!thirdRow.contains(c+"")) valid3=false;
            }
            if(valid1  ||  valid2 || valid3){
            lst.add(word);
            }
        }
        

        return lst.toArray(new String[0]);
    }
}