class Solution {
    public String convert(String s, int numRows) {
    int idxr = 0, idxc=0,n=numRows;
    int coln = s.length();
    char[][] mat =  new char[numRows][s.length()];
    if(n==1){
        return s;
    }
    boolean isdown = false;
    for(char c : s.toCharArray()){
        if(idxr>=n || idxc>=(coln)){
            break;
        }
        mat[idxr][idxc] = c;
        if(idxr==0){
            isdown = true;
        }
        else if(idxr==n-1){
            isdown = false;
        }

        if(isdown){
            idxr++;
        }else{
            idxc++;
            idxr--;
        }
    }

    StringBuffer sb = new StringBuffer();
    idxc = 0;
    idxr=0;

    for(int i=0;i<n;i++)
    {
        if(sb.length() == s.length()) return sb.toString();
        for(int j=0;j<coln;j++)
        if(mat[i][j]!='\0'){
        sb.append(mat[i][j]);
        }
    }
    
    return sb.toString();
}
}