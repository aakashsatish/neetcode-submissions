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
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return res;
    }
    public void smallest(TreeNode node, int k){
        if(node == null){
            return;
        }
        smallest(node.left, k);
        count += 1;
        if(count == k){
            res = node.val;
            return;
        }
        smallest(node.right, k);
    }
}
