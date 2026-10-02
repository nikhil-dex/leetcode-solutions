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
    public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> set = new HashSet<>();
        return isPairSum(root,k,set);
    
        
    }
    public boolean isPairSum(TreeNode root,int sum,HashSet<Integer> s){
        if(root==null) return false;
        if(isPairSum(root.left,sum,s)==true){
            return true;
        }
        if(s.contains(sum-root.val)){
            return true;
        }else{
            s.add(root.val);
        }
        return isPairSum(root.right,sum,s);

    }
    

}