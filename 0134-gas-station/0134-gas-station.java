class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curr_pet = 0,prev_pet = 0,start=0;
        for(int i=0;i<n;i++){
            curr_pet += gas[i]-cost[i];
            if(curr_pet<0){
                start = i+1;
                prev_pet+=curr_pet;
                curr_pet = 0;
            }
        }
        return ((curr_pet+prev_pet)>=0)?start:-1;
        
    }
}