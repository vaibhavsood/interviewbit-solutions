public class Solution {
    public boolean binSearch(boolean[] digits, int num) {
        String temp = Integer.toString(num);
        
        for (int i = 0; i < temp.length(); i++) {
            if ((digits[temp.charAt(i)-'0']) == false)
                return false;
        }
        
        return true;
    }
    
    public int solve(ArrayList<Integer> A, int B, int C) {
        int count = 0;
        
        if (B > Integer.toString(C).length())
            return 0;
            
        int bottom = 0;
        int top = 0;
        
        String tempTop = "";
        String tempBottom = "";
        for (int i = 0; i < B; i++) {
            tempTop += "9";
            if (i == 0 && B != 1)
                tempBottom += "1";
            else
                tempBottom += "0";
        }
        if (B == Integer.toString(C).length())
            top = C-1;
        else
            top = Integer.parseInt(tempTop);
        bottom = Integer.parseInt(tempBottom);
        
        boolean[] digits = new boolean[10];
        
        for (Integer digit : A)
            digits[digit] = true;

        for (int i = bottom; i <= top; i++) {
            if(binSearch(digits, i))
                count++;
        }
        
        return count;
    }
}
