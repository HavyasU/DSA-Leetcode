class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        ArrayList<String> lst = new ArrayList<>();
        
        for(int i=0;i<str.length-2;i++){
            if(first.equals(str[i]) && second.equals(str[i+1])){
                lst.add(str[i+2]);
            }
        }

        return lst.toArray(new String[0]);
    }
}