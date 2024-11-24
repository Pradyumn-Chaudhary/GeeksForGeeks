//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    void conquer(int arr[],int si,int mid,int ei){
    int merged[] = new int [ei-si+1];
    int idx1 = si;
    int idx2 = mid+1;
    int idx = 0;
    
    while(idx1<=mid && idx2<=ei){
        if(arr[idx1]<arr[idx2])
        merged[idx++] = arr[idx1++];
        else
        merged[idx++] = arr[idx2++];
    }
    while(idx1<=mid){
        merged[idx++] = arr[idx1++];
    }
    while(idx2<=ei){
        merged[idx++] = arr[idx2++];
    }
    for(int i = 0;i<merged.length;i++){
        arr[si+i] = merged[i];
    }
    }
    
    void divide(int arr[],int si,int ei){
    int mid = si + (ei-si)/2;
    if(si<ei){
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    }
    
    void mergeSort(int arr[], int si, int ei) {
        // code here
        divide(arr,si,ei);
    }
}
