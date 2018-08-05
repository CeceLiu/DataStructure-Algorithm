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
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathFromRoot(root, sum);
    }
    
    public int pathFromRoot(TreeNode root, int sum){
        if(root == null) return 0;
        int res = 0;
        // found a path from root to current node 
        if(root.val == sum)
            res = 1;
        // return shall include current path + # of left and right subtree
        return res + pathFromRoot(root.left, sum-root.val) + pathFromRoot(root.right, sum-root.val);
    }
}