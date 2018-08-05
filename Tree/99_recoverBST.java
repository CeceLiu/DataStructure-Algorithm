/*
Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.

with InOrder traversal get a list of nodes/values, sort values then resign back to nodes
*/

public class Solution {
  public TreeNode recover(TreeNode root) {
    if(root==null)
      return root;
    List<TreeNode> nodes = new ArrayList<>();
    List<Integer> values = new ArrayList<>();
    inOrder(root, nodes, values);
    Collections.sort(values);
    for(int i=0; i<nodes.size(); i++){
      nodes.get(i).key = values.get(i);
    }
    return root;
  }
  
  public void inOrder(TreeNode root, List<TreeNode> nodes, List<Integer> values){
    if(root!=null){
      inOrder(root.left, nodes, values);
      nodes.add(root);
      values.add(root.key);
      inOrder(root.right, nodes, values);
    }
  }
}
