//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = mat.length-1,m = mat[0].length-1;
        int left = 0,right = m,top = 0,bottom = n;
        
        while(left<=right && top<=bottom){
            for(int i = left;i<=right && left<=right && top<=bottom;i++){
                list.add(mat[top][i]);
            }
            top++;
            for(int i = top;i<=bottom && left<=right && top<=bottom;i++){
                list.add(mat[i][right]);
            }
            right--;
            for(int i = right;i>=left && left<=right && top<=bottom;i--){
                list.add(mat[bottom][i]);
            }
            bottom--;
            for(int i = bottom;i>=top && left<=right && top<=bottom;i--){
                list.add(mat[i][left]);
            }
            left++;
        }
        return list;
    }
}
