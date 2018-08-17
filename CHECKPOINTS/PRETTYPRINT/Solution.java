public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int start = 0;
        int[][] r = new int[2*A-1][2*A-1];

        for (int i = 0; i < 2*A-1; i++)
            for (int j = 0; j < 2*A-1; j++)
                r[i][j] = 0;
        
        int A_temp = A;
        for (int i = 0; i < A; i++) {
            int row = i, col = i, len = 2*A_temp-1;
            
            for (int j = 0; j < len; j++) {
                r[row][col+j] = A_temp;
            }
            for (int j = 0; j < len-1; j++) {
                r[row+j+1][col+len-1] = A_temp;
            }
            for (int j = 0; j < len-1; j++) {
                r[row+len-1][col+len-1-j-1] = A_temp;
            }
            for (int j = 0; j < len-2; j++) {
                r[row+len-1-j-1][col] = A_temp;
            }
            A_temp--;
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2*A-1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 2*A-1; j++)
                temp.add(r[i][j]);
            res.add(temp);
        }
        return res;
    }
}
