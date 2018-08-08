public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(B.size(), Collections.reverseOrder());
        long sum = 0, count = 0;
        
        for (Integer num : B)
            pq.add(num);
        
        while (count < A) {
            int temp = pq.poll();
            //temp %= (Math.pow(10, 9) + 7);
            sum += temp;
            sum %= (Math.pow(10, 9) + 7);
            pq.add(temp/2);
            count++;
        }
        
        return (int)sum;
    }
}
