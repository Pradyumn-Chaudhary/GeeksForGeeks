//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean check(int[] arr, long mid, int k){
        int count = 1;
        int sum = 0;
        for(int e : arr){
            sum += e;
            if(sum > mid){
                count++;
                sum = e;
            }
        }
        if(count > k){
            return false;
        }
        return true;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        long low = Integer.MIN_VALUE;
        long high = 0;
        for(int e : arr){
            if(e > low){
                low = e;
            }
            high += e;
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
