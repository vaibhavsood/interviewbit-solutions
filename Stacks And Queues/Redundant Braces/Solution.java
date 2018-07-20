public class Solution {
    public int braces(String A) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            switch (A.charAt(i)) {
                case '(':
                    s.push(A.charAt(i));
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    s.push(A.charAt(i));
                    break;
                case ')':
                    if (s.peek() == '(')
                        return 1;
                    else
                        s.pop();
                        s.pop();
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
}
