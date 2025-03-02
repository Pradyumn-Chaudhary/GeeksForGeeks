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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    public static int divide(int[] arr, int si, int ei) {
        int count = 0;
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            count += divide(arr, si, mid); // Count inversions in left half
            count += divide(arr, mid + 1, ei); // Count inversions in right half
            count += conquer(arr, si, mid, ei); // Count cross inversions
        }
        return count;
    }
    
    public static int conquer(int[] arr, int si, int mid, int ei) {
        int[] conquered = new int[ei - si + 1];
        int idx = 0, idx0 = si, idx1 = mid + 1;
        int count = 0;

        while (idx0 <= mid && idx1 <= ei) {
            if (arr[idx0] <= arr[idx1]) {
                conquered[idx++] = arr[idx0++];
            } else {
                conquered[idx++] = arr[idx1++];
                count += (mid - idx0 + 1); // Counting inversions
            }
        }
        
        while (idx0 <= mid) {
            conquered[idx++] = arr[idx0++];
        }
        while (idx1 <= ei) {
            conquered[idx++] = arr[idx1++];
        }
        
        // Copy the sorted subarray back to the original array
        System.arraycopy(conquered, 0, arr, si, conquered.length);
        
        return count;
    } 
    
    static int inversionCount(int arr[]) {
        return divide(arr, 0, arr.length - 1);
    }
}
