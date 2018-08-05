/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorderRC(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(Node root, List<Integer> res){
        if(root == null)
            return;
        if(root.children != null){
            for(Node child: root.children){
                helper(child, res);
            }
        }
        res.add(root.val);
    }

 // stack with level order traversal; reverse
  public List<Integer> postorder(Node root) {
        // LinkedList.addFirst()        
        List<Integer> res = new ArrayList<>();
        if( root == null)
            return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            Node curr = stack.pollFirst();
            res.add(curr.val);
            if(curr.children != null){
                for(Node child: curr.children){
                    stack.offerFirst(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
        
}