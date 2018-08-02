/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                if (root.next == null) {
                    root.left.next = null;
                } else {
                    TreeLinkNode temp = root.next;
                    while (temp.next != null && temp.left == null && temp.right == null)
                        temp = temp.next;
                    if (temp.left != null)
                        root.left.next = temp.left;
                    else
                        root.left.next = temp.right;
                }
            }
        }
        if (root.right != null) {
            if (root.next != null) {
                TreeLinkNode temp = root.next;
                while (temp.next != null && temp.left == null && temp.right == null)
                    temp = temp.next;
                if (temp.left != null)
                    root.right.next = temp.left;
                else
                    root.right.next = temp.right;
            } else {
                root.right.next = null;
            }
        }
        if (root.left != null)
            connect(root.left);
        if (root.right != null)
            connect(root.right);
    }
}
