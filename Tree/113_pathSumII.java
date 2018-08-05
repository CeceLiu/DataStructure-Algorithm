/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<Integer> curr = new ArrayList<>();
        helper(root, sum, curr, res);
        return res;
    }

    public static void helper(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res){
        curr.add(root.val);
        if(root.left == null && root.right == null){
            if( root.val == sum)
                res.add(new ArrayList<>(curr));
        }
        // check children
        if(root.left != null)
            helper(root.left, sum-root.val, curr, res);
        if(root.right != null)
            helper(root.right, sum-root.val, curr, res);
        // remove the last added before return to previous
        curr.remove(curr.size()-1);
        return;
    }
}