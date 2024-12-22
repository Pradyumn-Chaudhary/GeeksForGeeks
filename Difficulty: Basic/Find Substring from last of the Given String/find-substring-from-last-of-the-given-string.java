//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String x = input[0];
            String y = input[1];
            Solution ob = new Solution();
            System.out.println(ob.search(x, y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int search(String X, String Y) {
        // code here
        int r = -1;
            for(int j = 0;j<=X.length()-Y.length();j++){
                String s = X.substring(j,j+Y.length());
                if(s.equals(Y))
                r = j+1;
            }
        return r;
    }
}