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
            int ans = sln.count(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int count(int[] arr, int target) {
        // code here
        int low = 0,high=arr.length-1,count = 0;
        int j = 0;
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid]==target){
                high = mid - 1;
                j = mid;
            }else if(arr[mid]>target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        while(j < arr.length && arr[j]==target){
            count++;
            j++;
        }
        return count;
    }
}
