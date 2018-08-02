/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int findPathSum(TreeNode A, int B, int[] sum) {
        sum[0] += A.val;
        if (A.left == null && A.right == null) {
            //System.out.println("sum:" + sum[0]);
            if (sum[0] == B) {
                return 1;
            } else {
                sum[0] -= A.val;
                return 0;
            }
        }
        if (A.left != null) {
            if (findPathSum(A.left, B, sum) == 1) {
                return 1;
            }
        }
        if (A.right != null) {
            if(findPathSum(A.right, B, sum) == 1) {
                return 1;
            } else {
                sum[0] -= A.val;
            }
        }
        return 0;
    }
    public int hasPathSum(TreeNode A, int B) {
        int[] sum = new int[1];
        sum[0] = 0;
        return findPathSum(A, B, sum);
    }
}
