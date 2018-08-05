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
    public int sumNumbers(TreeNode root) {
        if( root == null)
            return 0;
        List<Integer> res = new ArrayList<>();
        helper(root, "", res);
        int sum = 0;
        for(Integer iter: res)
            sum += iter;
        return sum;
    }

    public static void helper(TreeNode root, String sbd, List<Integer> res){
        if( root.left == null && root.right == null){
            res.add(Integer.valueOf(sbd+root.val));
        }
        if(root.left != null)
            helper(root.left, sbd + root.val, res);
        if(root.right != null)
            helper(root.right, sbd+root.val, res);
    }

    // remove the String convert part; top to bottom
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[2];
        if(root == null)
            return 0;
        helper(root, sum);
        return sum[1];
    }

    public static void helper(TreeNode root, int[] sum){
        sum[0] = 10*sum[0] + root.val;
        if( root.left == null && root.right == null){
            sum[1] += sum[0];
        }
        if(root.left != null){
            helper(root.left, sum);
        }
        if(root.right != null){
            helper(root.right, sum);
        }
        sum[0] = (sum[0] - root.val)/10;
        return;
    }
}