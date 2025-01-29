//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        double res = 1;
        if(e==0){
            return res;
        }
        if(e<0){
            e *= (-1);
            b = 1/b;
        }
        while(e>0){
            if(e%2==1){
                res *= b;
            }
            e /= 2;
            b *= b;
        }
        return res;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends