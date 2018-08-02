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
    public int findPathSum(TreeNode A, int B, int[] sum, ArrayList<ArrayList<Integer>> res,
                            ArrayList<Integer> curr) {
        sum[0] += A.val;
        curr.add(A.val);
        if (A.left == null && A.right == null) {
            //System.out.println("sum:" + sum[0]);
            if (sum[0] == B) {
                res.add(curr);
                return 1;
            } else {
                sum[0] -= A.val;
                curr.remove(curr.size()-1);
                return 0;
            }
        }
        if (A.left != null) {
            if (findPathSum(A.left, B, sum, res, curr) == 1) {
                return 1;
            }
        }
        if (A.right != null) {
            if(findPathSum(A.right, B, sum, res, curr) == 1) {
                return 1;
            } else {
                sum[0] -= A.val;
                curr.remove(curr.size()-1);
            }
        }
        return 0;
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        int[] sum = new int[1];
        sum[0] = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        findPathSum(A, B, sum, res, temp);
        return res;
    }
}
