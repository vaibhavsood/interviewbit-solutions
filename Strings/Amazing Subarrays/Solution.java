public class Solution {
    public boolean isVowel(char a) {
        a = Character.toLowerCase(a);
        if (a == 'a' || a == 'e' || a == 'i' ||
            a == 'o' || a == 'u')
            return true;
        return false;   
    }
    
    public int solve(String A) {
        int sum = 0;
        
        for (int i = 0; i < A.length(); i++)
            if (isVowel(A.charAt(i)))
                sum += A.length()-i;
                
        return sum % 10003;
    }
}
