class Solution {
    public boolean checkString(String s) {
        boolean appeardB = false;

        int n = s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                appeardB = true;
            }
            if(s.charAt(i)=='a' && appeardB==true){
                return false;
            }
        }
        return true;

        
    }
}