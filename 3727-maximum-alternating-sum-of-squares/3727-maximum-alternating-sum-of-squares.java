
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i]= nums[i]<0?-nums[i]:nums[i];
        }
        Arrays.sort(nums);
        long res = 0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                res-=nums[i]*nums[i];
            }else{
                res+=nums[i]*nums[i];
            }
            
        }
        return res;
        
    }
}