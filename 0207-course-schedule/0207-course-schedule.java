class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adj = new ArrayList<>();
      int[] state = new int[numCourses];

      for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
      }

      for(int[] p:prerequisites){
        adj.get(p[1]).add(p[0]);
      }

      for(int i=0;i<numCourses;i++){
        if(state[i]==0 && dfs(i,adj,state)){
            return false;
        }
      }
      return true;
        
    }

    public static boolean dfs(int i,List<List<Integer>> adj,int[] state){
        if(state[i]==1){
            return true;
        }
        if(state[i]==2){
            return false;
        }
        state[i] = 1;
        for(int next:adj.get(i)){
            if(dfs(next,adj,state)){
                return true;
            }
        }
        state[i] = 2;
        return false;
    }
}