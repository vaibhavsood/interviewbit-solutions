public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if (B > A.size())
            return null;
            
        ArrayList<Integer> r = new ArrayList<>();
        r.add(0);
        
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < B; i++) {
            if (m.get(A.get(i)) == null) {
                int temp = r.get(0);
                r.set(0, ++temp);
                m.put(A.get(i), 1);
                continue;
            }
            int temp1 = m.get(A.get(i));
            m.put(A.get(i), ++temp1);
        }
        
        int first = 0, last = B;
        
        while (last < A.size()) {
            int prev_count = r.get(r.size()-1);
            int first_num = A.get(first);
            int curr_count = r.get(r.size()-1);
            int first_num_count = m.get(first_num);
            
            if (first_num_count == 1) {
                m.remove(first_num);
                prev_count--;
            }
                
            if (first_num_count != 1)
                m.put(first_num, --first_num_count);
                    
            int last_num_count = 0;
            int last_num = A.get(last);
                
            if (m.get(last_num) == null) {
                last_num_count = 1;
            } else {
                last_num_count = m.get(last_num)+1;
            }
                
            if (last_num_count == 1)
                prev_count++;
                
            m.put(last_num, last_num_count);
                
            r.add(prev_count);
            first++;
            last++;
        }
        
        return r;
    }
}
