class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] adjMat = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjMat[i][j] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        int res = 0;
        int[] key = new int[n];
        Arrays.fill(key,Integer.MAX_VALUE);
        boolean[] mset = new boolean[n];
        key[0] = 0;
        for(int count = 0;count<n;count++){
            int u = -1;
            for(int i=0;i<n;i++){
                if(!mset[i] && (u==-1 || key[i]<key[u])){
                    u=i;
                }
            }
            mset[u] = true;
            res = res + key[u];
            for(int v=0;v<n;v++){
                if(!mset[v] && adjMat[u][v]!=0 && adjMat[u][v]<key[v]){
                    key[v]=adjMat[u][v];
                }
            }
        }
        return res;


        
        
    }
}


//9