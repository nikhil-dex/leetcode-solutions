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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        vTrav(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        for (List<int[]> list : map.values()) {
            // Sort by row, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];

                return a[1] - b[1];
            });
            List<Integer> column = new ArrayList<>();
            for (int[] pair : list) {
                column.add(pair[1]);
            }
            res.add(column);
        }

        return res;
    }

    public void vTrav(
        TreeNode root,
        int hd,
        int row,
        TreeMap<Integer, List<int[]>> map
    ) {

        if (root == null)
            return;

        map.computeIfAbsent(hd, k -> new ArrayList<>())
           .add(new int[]{row, root.val});

        vTrav(root.left, hd - 1, row + 1, map);

        vTrav(root.right, hd + 1, row + 1, map);
    }
}