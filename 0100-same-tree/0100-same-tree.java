/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        if(p==null && q==null){
            return true;
        }else if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }
     
        pq.add(p);
        qq.add(q);
        while(!pq.isEmpty() && !qq.isEmpty()){
            TreeNode currp = pq.poll();
            TreeNode currq = qq.poll();
            if(currp!=null && currq!=null){
                if(currp.val!=currq.val){
                    return false;
                }
            }else if((currp==null && currq!=null) || (currp!=null && currq==null)){
                return false;
            }
            if(currp!=null){
                pq.add(currp.left);
                pq.add(currp.right);
            }
            if(currq!=null){

            qq.add(currq.left);
            qq.add(currq.right);
            }

        }
        return true;
        
    }

   
}