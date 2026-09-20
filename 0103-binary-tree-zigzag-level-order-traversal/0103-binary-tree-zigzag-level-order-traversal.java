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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        s1.push(root);
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
        if(root==null) return res;
        List<Integer> level;
        while(!s1.isEmpty() || !s2.isEmpty()){
            level = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                level.add(curr.val);
                if(curr.left!=null) s2.push(curr.left);
                if(curr.right!=null) s2.push(curr.right);
            }
            if(level.size()!=0) res.add(level);
            level = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode curr = s2.pop();
                level.add(curr.val);
                if(curr.right!=null) s1.push(curr.right);
                if(curr.left!=null) s1.push(curr.left);
            }
            if(level.size()!=0) res.add(level);
        }
        return res;


        
    }
}