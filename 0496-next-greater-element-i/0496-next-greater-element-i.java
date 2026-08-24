class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        
    
        
        
        return nextGreater(nums1,nums1.length,nums2,nums2.length);

    }





    private int[] nextGreater(int[] nums1,int n1,int[] nums2,int n2){
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(nums2[n2-1]);
        int last = nums2[n2-1];
        for(int i=0;i<n1;i++){
            if(nums1[i]==last){
                nums1[i] = -1;
                break;
            }
        }
        for(int i=n2-2;i>=0;i--){
            while(stk.isEmpty()==false && nums2[i]>=stk.peek()){
                stk.pop();
            }
            int ng = (stk.isEmpty())?-1:stk.peek();
            int c = 0;
           
            while(c<n1){
                if(nums2[i]==nums1[c]){
                    nums1[c] = ng;
                    break;
                }
                c++;
            }
            stk.push(nums2[i]);
        }
        return nums1;
    }
}