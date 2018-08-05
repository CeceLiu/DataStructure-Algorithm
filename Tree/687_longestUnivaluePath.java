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
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    // bottom up; 
    // childre return: the max univalue path in its tree
    // current node: compare with left and right; increase value; update global
    // return to parent: max value from left or right
    public int helper(TreeNode root, int[] res){
        if(root == null)
            return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        left = ( root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = ( root.right != null && root.right.val == root.val) ? right + 1 : 0;
        res[0] = Math.max(res[0], left+right);
        return Math.max(left, right);
    }

    // top down; pass parent value to children
    // get the result from left tree AND right tree; compare with current tree
    // i.e. max of left or right vs path through current node
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        int maxChild = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(maxChild, helper(root.left, root.val) + helper(root.right, root.val));
    }
    
    public int helper(TreeNode root, int parent){
        if(root == null || root.val != parent)
            return 0;
        else{
            return 1 + Math.max(helper(root.left, root.val), helper(root.right, root.val));
        }
    }
}