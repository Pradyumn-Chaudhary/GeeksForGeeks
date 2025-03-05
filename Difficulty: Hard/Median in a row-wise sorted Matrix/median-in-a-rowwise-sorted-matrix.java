//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean blackBox(int[][] mat, int midNum, int n){
        int count = 0;
        for(int i = 0;i < mat.length; i++){
            int low = 0, high = mat[0].length-1;
            while(low<=high){
                int mid = (low + high) / 2;
                if(mat[i][mid] > midNum){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            count += low;
        }
        if(count >= n){
            return true;
        }
        return false;
    }
    
    int median(int mat[][]) {
        int n = (mat.length * mat[0].length)/2;
        // code here
        int low = 1, high = 2000;
        while(low <= high){
            int mid = (low + high) / 2;
            if(blackBox(mat,mid,n + 1)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}