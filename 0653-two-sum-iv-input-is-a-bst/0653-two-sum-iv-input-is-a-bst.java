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
    Set<Integer> set = new HashSet<>();
    boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        inorder(root,k);
        return res;
        
    }
    public void inorder(TreeNode root,int k){
        if(root!=null){
            inorder(root.left,k);
            set.add(k-root.val);
            if(set.contains(root.val) && 2*root.val!=k){
                res = true;
                return;
            }
            inorder(root.right,k);
        }
    }

}