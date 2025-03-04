//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends





//Back-end complete function Template for Java

class Solution {
    public static boolean check(int[] arr, long mid, int k){
        int student = 1;
        int count = 0;
        for(int e : arr){
            count += e;
            if(count > mid){
                count = e;
                student++;
            }
        }
        if(student > k){
            return false;
        }
        return true;
    }
    
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k){
            return -1;
        }
        long low = Integer.MIN_VALUE;
        long high = 0;
        for(int e : arr){
            if(e > low)
            low = e;
            high += (long)e;
        }
        while(low <= high){
            long mid = (low + high) / 2;
            boolean isPossible = check(arr,mid,k);
            if(isPossible){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int) low;
    }
}