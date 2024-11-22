//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for 

class Solution {
    public int getMinDiff(int k, int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Initialize variables
        int n = arr.length;
        int result = arr[n - 1] - arr[0]; // Initial max difference
        
        // Step 3: Modify heights and find the minimum difference
        int smallest = arr[0] + k;  // Smallest tower after increasing
        int largest = arr[n - 1] - k; // Largest tower after decreasing

        // Ensure smallest is actually smaller than largest
        if (smallest > largest) {
            int temp = smallest;
            smallest = largest;
            largest = temp;
        }
        
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            result = Math.min(result, maxHeight - minHeight);
        }
        
        return result;
    }
}
