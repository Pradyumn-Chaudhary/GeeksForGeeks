//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static void helper(String s,String Permutation,HashSet<String> set){
       if(s.length() == 0){
           set.add(Permutation);
       }
       for(int i = 0;i<s.length();i++){
           char newChar = s.charAt(i);
           String newstr = s.substring(0,i) + s.substring(i+1);
           helper(newstr,Permutation + newChar,set);
       }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> set = new HashSet<>();
        helper(s,"",set);
        return new ArrayList<>(set);
    }
}