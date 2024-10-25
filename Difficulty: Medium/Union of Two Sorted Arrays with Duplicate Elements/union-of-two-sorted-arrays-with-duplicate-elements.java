//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                // Add only if the element is not a duplicate of the last added one
                if (arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) {
                    arr.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) {
                    arr.add(a[i]);
                }
                i++;
            } else {
                if (arr.isEmpty() || arr.get(arr.size() - 1) != b[j]) {
                    arr.add(b[j]);
                }
                j++;
            }
        }

        // Add remaining elements from array a, if any
        while (i < a.length) {
            if (arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) {
                arr.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from array b, if any
        while (j < b.length) {
            if (arr.isEmpty() || arr.get(arr.size() - 1) != b[j]) {
                arr.add(b[j]);
            }
            j++;
        }

        return arr;
    }
}
