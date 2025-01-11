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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n <= 2) return 0; // No water can be trapped if array size is <= 2

        int left = 0, right = n - 1; // Two pointers
        int leftMax = 0, rightMax = 0; // Max heights on both ends
        int res = 0;

        while (left <= right) {
            if (arr[left] < arr[right]) {
                // Process left pointer
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    res += leftMax - arr[left];
                }
                left++;
            } else {
                // Process right pointer
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    res += rightMax - arr[right];
                }
                right--;
            }
        }

        return res;
    }
}

