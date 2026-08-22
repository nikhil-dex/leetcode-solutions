class Solution {
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
       
        int[][] mat = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                mat[i][j] = matrix[i][j]=='0'?0:1;
            }
        }
      
        int res = largestHist(mat[0],C);
        for(int i=1;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]==1){
                    mat[i][j]+=mat[i-1][j];
                }
            }
            res = Math.max(res,largestHist(mat[i],C));
        }
        return res;
    }

    private int largestHist(int[] arr,int n){
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