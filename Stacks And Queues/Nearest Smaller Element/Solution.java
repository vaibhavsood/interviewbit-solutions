public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        s.push(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i-1) < A.get(i)) {
                res.add(A.get(i-1));
            } else {
                if (A.get(i) > res.get(res.size()-1)) {
                    res.add(res.get(res.size()-1));
                } else {
                    while (s.empty() == false && s.peek() >= A.get(i))
                        s.pop();
                    if (s.empty() == false) {
                        res.add(s.peek());
                    } else {
                        res.add(-1);
                    }
                }
            }
            s.push(A.get(i));
        }
        return res;
    }
}
