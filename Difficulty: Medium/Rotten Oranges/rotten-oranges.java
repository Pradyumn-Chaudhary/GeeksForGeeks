//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}

    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        int arr[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==2){
                    arr[i][j] = 2;
                    q.add(new Pair<>(new Pair<>(i, j), 0));
                }else{
                    arr[i][j] = mat[i][j];
                }
            }
        }
        int drow[] = {0,-1,0,1};
        int dcol[] = {-1,0,1,0};
        int time = 0;
        while(!q.isEmpty()){
                Pair<Pair<Integer,Integer>,Integer> p1 = q.remove();
            int r = p1.getFirst().getFirst();
            int c = p1.getFirst().getSecond();
            int tm = p1.getSecond();
                time = Math.max(time,tm);
            for(int i = 0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && arr[nrow][ncol] == 1){
                    arr[nrow][ncol] = 2;
                    q.add(new Pair<>(new Pair<>(nrow,ncol),tm+1));
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(arr[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}