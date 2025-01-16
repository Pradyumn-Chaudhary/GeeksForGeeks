//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int a[] = new int[arr.length];
        int product = 1;
        boolean isZero = false;
        int c = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
               product *= arr[i]; 
            }
            else{
               isZero = true;
               c++;
           }
        }
        
        if(isZero && c==1){
            for(int i = 0;i<arr.length;i++){
                if(arr[i]==0){
                    a[i]=product;
                }else{
                    a[i]=0;
                }
            }
        }else if(c>1){
            for(int i = 0;i<arr.length;i++){
            a[i] = 0;
            }
            }else{
            for(int i = 0;i<arr.length;i++){
            a[i] = product/arr[i];
        }
        }
        return a;
    }
}
