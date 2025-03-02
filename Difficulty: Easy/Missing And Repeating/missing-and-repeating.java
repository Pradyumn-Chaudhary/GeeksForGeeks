//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long S1 = 0, Sn1 = 0, S2 = 0, Sn2 = 0;
        int repeat = -1, missing = -1;
        for(int i = 0;i<arr.length;i++){
            S1 += arr[i];
            Sn1 += i+1;
            
            S2 += (arr[i]*arr[i]);
            Sn2 += ((i+1)*(i+1));
        }
        long xy = S1 - Sn1;
        long xy2 = S2 - Sn2;
        long XY = xy2/xy;
        repeat = (int)((xy + XY)/2);
        missing = (int)(XY - repeat);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(repeat);
        list.add(missing);
        return list;
    }
}
