//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int sum = arr[0];
int max = arr[0];
int min = arr[0];
int totalsum = arr[0];
int n = arr.length;
        // Your code here
        for(int i = 1;i<n;i++){
            sum = Math.max(sum+arr[i],arr[i]);
            max = Math.max(sum,max);
            totalsum+=arr[i];
        }
        sum = arr[0];
        for(int i = 1;i<n;i++){
            sum = Math.min(sum+arr[i],arr[i]);
            min = Math.min(sum,min);
        }
        int maxcircular = totalsum - min;
        return Math.max(max,maxcircular);
    }
}
