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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        sdfs(root, res);
        return String.join(",", res);
    }
    public void sdfs(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        sdfs(root.left, res);
        sdfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] i = {0};
        return ddfs(values, i);
    }
    public TreeNode ddfs(String[] values, int[] i){
        if(values[i[0]].equals("N")){
            i[0]+= 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[i[0]]));
        i[0] += 1;
        node.left = ddfs(values, i);
        node.right = ddfs(values, i);

        return node;
    }
}
