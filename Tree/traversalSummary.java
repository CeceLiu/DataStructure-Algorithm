/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {

  public List<Integer> preOrder(TreeNode root){
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()){
      if(curr != null){
        stack.offerFirst(curr);
        res.add(curr.val); // Add to res before access children
        curr = curr.left;
      }
      else{
        curr = stack.pollFirst();
        curr = curr.right;
      }
    }
    return res;
  }

  public List<Integer> postOrder(TreeNode root){
        // List interface doesn't have method addFirst so directly declare as LinkedList
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        // reverse Root Right Left 
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.offerFirst(curr);
                res.addFirst(curr.val); // reverse the process of PreOrder
                curr = curr.right; // reverse the process of PreOrder
            }
            else{
                curr = stack.pollFirst();
                curr = curr.left;
            }
        }
        return res;
  }

  public List<Integer> inOrder(TreeNode root){
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while( curr!=null || !stack.isEmpty()){
      if( curr != null){
        stack.offerFirst(curr);
        curr = curr.left;
      }
      else{
        curr = stack.pollFirst();
        res.add(curr.val); // Add to res after ALL left node
        curr = curr.right;
      }
    }
    return res;
  }

}
