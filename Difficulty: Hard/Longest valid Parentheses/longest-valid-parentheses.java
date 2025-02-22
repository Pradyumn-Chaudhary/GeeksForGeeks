//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution {
    static int maxLength(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);  // Initialize stack with -1 to handle base case
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();  // Remove matching '(' index
                if (!st.isEmpty()) {
                    maxLength = Math.max(maxLength, i - st.peek());
                } else {
                    st.push(i);  // Push unmatched ')' index
                }
            }
        }
        return maxLength;
    }
}
