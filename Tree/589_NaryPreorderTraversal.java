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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(Node root, List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        if(root.children != null){
            for(Node child: root.children){
                helper(child, res);
            }
        }
    }

    // Preorder with stack; offer from right to left
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if( root == null)
            return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            Node curr = stack.pollFirst();
            res.add(curr.val);
            if(curr.children != null){
                for(int i=curr.children.size()-1; i>=0; i--){
                    stack.offerFirst(curr.children.get(i));
                }
            }
        }
        return res;
    }
}