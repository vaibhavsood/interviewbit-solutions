public class Solution {
    public int findNum(ArrayList<Integer> A, int i, int j) {
        int find = A.get(i)+A.get(j);
        int low = 0, high = A.size()-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (A.get(mid) < -find)
                low = mid+1;
            else if (A.get(mid) > -find)
                high = mid-1;
            else {
                if (mid != i && mid != j)
                    return mid;
                else
                    break;
            }
        }
        return -1;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                int index = findNum(A, i, j);
                if (index != -1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(index));
                    Collections.sort(temp);
                    res.add(temp);
                }
            }
        }
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> elem : res) {
            resList.add(elem);
        }
        return resList;
    }
}
