public class Solution {
    public String simplifyPath(String A) {
        Stack<Character> s = new Stack<>();
        s.push('/');
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == '.') {
                if (i == A.length()-1)
                    break;
                else {
                    //if (i == 1)
                    //    return "/";
                    if (A.charAt(i+1) == '.') {
                        if (s.size() != 1)
                            s.pop();
                        while (s.peek() != '/')
                            s.pop();
                        i += 2;
                    } else {
                        i++;
                        continue;
                    }
                }
            } else {
                if (A.charAt(i) == '/') {
                    if (s.peek() != '/')
                        s.push(A.charAt(i));
                } else {
                    s.push(A.charAt(i)); 
                }
            }
        }
        StringBuilder res = new StringBuilder("");
        if (s.peek() == '/') {
            if (s.size() != 1) {
                s.pop();
            }
        }
        while (s.empty() == false) {
            res.append(s.pop());
        }
        return res.reverse().toString();
    }
}
