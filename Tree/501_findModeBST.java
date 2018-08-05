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

    // time O(n) space O(n)
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        inOrder(root, map, max);
        List<Integer> temp = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == max[0]){
                temp.add(entry.getKey());
            }
        }
        int[] res = new int[temp.size()];
        for(int i=0; i<temp.size(); i++)
            res[i] = temp.get(i);
        return res;
    }

    public void inOrder(TreeNode root, HashMap<Integer, Integer> map, int[] max){
        if(root == null)
            return;
        inOrder(root.left, map, max);
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        max[0] = Math.max(max[0], map.get(root.val));
        inOrder(root.right, map, max);
    }
}