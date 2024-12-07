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
    // Function to count inversions in the array
    static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Left subarray index
        int j = mid + 1; // Right subarray index
        int k = left;    // Merged array index
        int invCount = 0;

        // Merge two sorted subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in the left subarray
                // are greater than arr[j]
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of the left subarray
        while (i <= mid)
            temp[k++] = arr[i++];

        // Copy remaining elements of the right subarray
        while (j <= right)
            temp[k++] = arr[j++];

        // Copy merged elements back to the original array
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }

    static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in the left subarray
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right subarray
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }

        return invCount;
    }

    static int inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }
}
