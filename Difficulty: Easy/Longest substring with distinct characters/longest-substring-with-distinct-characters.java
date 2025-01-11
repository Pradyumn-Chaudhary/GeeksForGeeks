//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        if(s.length()==0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int max = 1;
        int c = 1;
        int j = 0;
        set.add(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
                while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
                }
            }
            set.add(s.charAt(i));
            c = (i - j) + 1;
            max = Math.max(c,max);
        }
        return max;
    }
}