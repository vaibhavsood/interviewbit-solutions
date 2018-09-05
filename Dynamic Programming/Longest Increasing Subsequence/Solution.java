public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int[] dp = new int[A.length];
        dp[0] = 1;

        for (int i = 1; i < A.length; i++) {
            int temp = Integer.MIN_VALUE;
            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    flag = true;
                    if ((dp[j]) > temp) {
                        temp = dp[j];
                    }
                }
            }
            if (flag == false)
                dp[i] = 1;
            else
                dp[i] = temp+1;
            //System.out.println(A[i] + "," + dp[i]);
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < dp.length; i++)
            if (dp[i] > max)
                max = dp[i];
        return max;
    }
}
