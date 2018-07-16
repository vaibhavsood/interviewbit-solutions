public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                int temp = A.get(i)+A.get(j);
                int low = 0, high = A.size()-1;
                while (low <= high) {
                    int mid = low + (high-low)/2;
                    int sum = temp + A.get(mid);
                    if (mid != i && mid != j) {
                        if (Math.abs(B-sum) < diff) {
                            diff = Math.abs(B-sum);
                            ans = sum;
                        }
                    }
                    if (sum > B) {
                        high = mid-1;
                    } else {
                        low = mid+1;
                    }
                }
            }
        }
        
        return ans;
    }
}
