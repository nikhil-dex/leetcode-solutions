class Solution {
    public int largestRectangleArea(int[] heights) {
        return result(heights,heights.length);
    }

    private int result(int[] arr,int n){
        Deque<Integer> stk = new ArrayDeque<>();
        int res = 0;
        int tp;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                tp = stk.pop();
                int curr = arr[tp]*(stk.isEmpty()?i:(i-stk.peek()-1));
                res = Math.max(res,curr);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            tp = stk.pop();
            int curr = arr[tp]*(stk.isEmpty()?n:(n-stk.peek()-1));
            res = Math.max(res,curr);
        }
        return res;
    }
}