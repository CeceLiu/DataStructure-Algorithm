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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        List<Integer> sbd = new ArrayList<>();
        helper(root, sbd, res);
        return res;
    }

    // preorder to traversal the tree
    public static void helper(TreeNode root, List<Integer> sbd, List<String> res){
        sbd.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder str = new StringBuilder();
            for(int i=0; i<sbd.size()-1; i++){
                str.append(sbd.get(i) + "->");
            }
            str.append(sbd.get(sbd.size()-1));
            res.add(str.toString());
        }
        if(root.left != null)
            helper(root.left, sbd, res);
        if(root.right != null)
            helper(root.right, sbd, res);
        sbd.remove(sbd.size()-1);
        return;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, "", res);
        return res;
    }

    // top to bottom; pass the value to child
    public static void helper(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null){
            res.add(path + root.val);
        }
        if(root.left != null)
            helper(root.left, path + root.val + "->", res);
        if(root.right != null)
            helper(root.right, path + root.val + "->", res);
    }
}