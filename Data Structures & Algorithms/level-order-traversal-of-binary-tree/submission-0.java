/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int qLen = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i =0; i < qLen; i++){
                TreeNode node = q.remove();
                if(node != null){
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(!level.isEmpty()){
                        res.add(level);
            }
        }
        return res;

    }
}
