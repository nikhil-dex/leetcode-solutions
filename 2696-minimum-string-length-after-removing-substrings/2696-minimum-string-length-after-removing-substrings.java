class Solution {
    public int minLength(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char val = s.charAt(i);
            if(stk.isEmpty()){

                stk.push(val);
            }else{
                if((val=='B' && stk.peek()=='A') || (val=='D' && stk.peek()=='C')){
                    stk.pop();
                }else{
                    stk.push(val);
                }
            }
        }

        return stk.size();
        
    }
}