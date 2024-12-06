//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        int[] freq = new int[n + 1];

        // Count the frequency of citations
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }

        int idx = n;
        
        // Variable to keep track of the count of papers
        // having at least idx citations
        int s = freq[n]; 
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        
        // Return the largest index for which the count of 
        // papers with at least idx citations becomes >= idx
        return idx;
    }
}