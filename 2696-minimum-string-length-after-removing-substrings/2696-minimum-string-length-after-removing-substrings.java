class Solution {
    public int minLength(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char val = s.charAt(i);
            if(!stk.isEmpty()){
                if((val=='B' && stk.peek()=='A') || (val=='D' && stk.peek()=='C')){
                    stk.pop();
                }else{
                    stk.push(val);
                }

            }else{
                stk.push(val);
            }
        }

        return stk.size();
        
    }
}