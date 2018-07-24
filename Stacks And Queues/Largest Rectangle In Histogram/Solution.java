/* Not efficient, stack based solution optimal */
public class Solution {
    public int findLowest(ArrayList<Integer> A, int low, int high) {
        int res = low;
        for (int i = low+1; i <= high; i++) {
            if (A.get(i) < A.get(res))
                res = i;
        }
        return res;
    }
    public int largestRectangleAreaRec(ArrayList<Integer> A, int low, int high) {
        if (low == high)
            return A.get(low);
        int pivot = findLowest(A, low, high);
        int areaLeft, areaRight;
        if (pivot != low)
            areaLeft = largestRectangleAreaRec(A, low, pivot-1);
        else
            areaLeft = A.get(low);
        if (pivot != high)
            areaRight = largestRectangleAreaRec(A, pivot+1, high);
        else
            areaRight = A.get(high);
        return Math.max(Math.max(A.get(pivot)*(high-low+1), areaLeft), areaRight);
    }
    public int largestRectangleArea(ArrayList<Integer> A) {
        return largestRectangleAreaRec(A, 0, A.size()-1);
    }
}
