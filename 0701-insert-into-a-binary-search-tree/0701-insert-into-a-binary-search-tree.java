
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
       return solve(root,val);
    }
    private TreeNode solve(TreeNode node, int val){
        if(node==null) return new TreeNode(val);
        if(val<node.val) node.left=solve(node.left,val);
        else if(val>node.val) node.right=solve(node.right,val);

        return node;
    }
}