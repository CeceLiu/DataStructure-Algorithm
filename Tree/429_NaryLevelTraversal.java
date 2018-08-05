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
// Use Dequa as Queue: offerFlast, pollFirst
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( root == null)
            return res;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0){
                Node curr = queue.pollFirst();
                level.add(curr.val);
                if(curr.children != null){
                    for(Node child: curr.children){
                        queue.offerLast(child);
                    }
                }
                size--;
            }
            res.add(level);
        }
        return res;
    }

    // recursion DFS; only create the current level list when first reach that level
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res);
        return res;
    }
    
    public void helper(Node root, int level, List<List<Integer>> res){
        if( root == null)
            return;
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        if(root.children != null){
            for(Node child: root.children){
                helper(child, level+1, res);
            }
        }
    }




}