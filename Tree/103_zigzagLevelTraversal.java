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

    // Recursion regular level order with flag; 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res, true);
        return res;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> res, boolean L2R){
        if( root == null)
            return;
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        if(L2R){
            res.get(level).add(root.val);
        }
        else{
            res.get(level).add(0, root.val);
        }
        helper(root.left, level+1, res, !L2R);
        helper(root.right, level+1, res, !L2R);
    }

    // iteration with space O(n) with Deque
    // L2R: pollLast and offerFirst from right to left
    // R2L: pollFirst and offerLast from left to right
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        boolean L2R = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size>0){
                if(L2R){
                    TreeNode curr = queue.pollLast();
                    level.add(curr.val);
                    if(curr.right != null)
                        queue.offerFirst(curr.right);
                    if(curr.left != null)
                        queue.offerFirst(curr.left);
                }
                else{
                    TreeNode curr = queue.pollFirst();
                    level.add(curr.val);
                    if(curr.left != null)
                        queue.offerLast(curr.left);
                    if(curr.right != null)
                        queue.offerLast(curr.right);
                }
                size--;
            }
            res.add(level);
            L2R = !L2R;
        }
        return res;
    }
}