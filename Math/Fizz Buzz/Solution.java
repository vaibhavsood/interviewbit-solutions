public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> r = new ArrayList<>();
        
        for (int i = 1; i <= A; i++) {
            int mod_3 = i%3;
            int mod_5 = i%5;
            if (mod_3 == 0 && mod_5 == 0) {
                r.add("FizzBuzz");
            } else if (mod_3 == 0) {
                r.add("Fizz");
            } else if (mod_5 == 0) {
                r.add("Buzz");
            } else {
                r.add(Integer.toString(i));
            }
        }
        
        return r;
    }
}
