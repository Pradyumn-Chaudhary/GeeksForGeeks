//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int index = 0, n = s.length();
        int sign = 1;  // Default to positive
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // Step 1: Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert digits to integer
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow/underflow
            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

   
}
