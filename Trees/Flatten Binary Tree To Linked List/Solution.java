/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode findRightMost(TreeNode a) {
        while (a.right != null)
            a = a.right;
        return a;
    }
    public TreeNode flatten(TreeNode a) {
        if (a == null)
            return null;
        if (a.left == null && a.right == null)
            return a;
        if (a.left != null && a.right != null) {
            TreeNode rm = findRightMost(a.left);
            rm.right = a.right;
            a.right = a.left;
            a.left = null;
            flatten(a.right);
        } else if (a.left == null) {
            flatten(a.right);
        } else if (a.right == null) {
            a.right = a.left;
            a.left = null;
            flatten(a.right);
        }
        return a;
    }
}
