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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode curr = stk.pop();
            res.add(curr.val);
            if(curr.right!=null) stk.push(curr.right);
            if(curr.left!=null) stk.push(curr.left);
        }
        return res;
    
        
        
    }

}