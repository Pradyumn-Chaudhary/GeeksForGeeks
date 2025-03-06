//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int count(String s, int n, int k){
        int arr[] = new int[26];
        int j = 0, f = 0, subString = 0;
        for(int i = 0; i <= n - k;i++){
            while(j < n && f < k){
                arr[s.charAt(j) - 'a']++;
                if(arr[s.charAt(j) - 'a'] == 1){
                    f++;
                }
                j++;
            }
            if(f >= k){
                subString += (n - j + 1);
            }
            arr[s.charAt(i) - 'a']--;
            if(arr[s.charAt(i) - 'a'] == 0){
            f--;
            }
        }
        return subString;
    }
    
    int countSubstr(String s, int k) {
        // your code here
        int n = s.length();
        return count(s,n,k) - count (s,n,k+1);
    }
}