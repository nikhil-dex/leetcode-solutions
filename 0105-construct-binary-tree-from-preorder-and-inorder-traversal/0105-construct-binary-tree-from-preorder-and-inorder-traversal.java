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
    static int preIndex = 0;
    public TreeNode buildTree(int[] pre, int[] in) {
        preIndex = 0;
        return cTree(in,pre,0,in.length-1);
        
    }
    public static TreeNode cTree(int[] in,int[] pre,int is,int ie){
        if(is>ie) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = 0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.val){
                inIndex = i;
                break;
            }
        }
        root.left = cTree(in,pre,is,inIndex-1);
        root.right = cTree(in,pre,inIndex+1,ie);
        return root;
    }
}