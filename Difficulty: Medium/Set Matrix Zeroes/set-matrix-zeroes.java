//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        boolean[] a = new boolean[mat.length];
        boolean[] b = new boolean[mat[0].length];

        // Mark rows and columns to be zeroed
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    a[i] = true;
                    b[j] = true;
                }
            }
        }

        // Set rows to zero
        for (int i = 0; i < a.length; i++) {
            if (a[i]) {
                for (int j = 0; j < mat[0].length; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Set columns to zero
        for (int j = 0; j < b.length; j++) {
            if (b[j]) {
                for (int i = 0; i < mat.length; i++) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
