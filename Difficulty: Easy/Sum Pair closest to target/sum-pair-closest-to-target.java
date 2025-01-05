//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr.length < 2) return result;

        Arrays.sort(arr); // Sort the array for two-pointer technique
        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int num1 = 0, num2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int currentDiff = Math.abs(target - sum);

            if (currentDiff < closestDiff) {
                closestDiff = currentDiff;
                maxDiff = Math.abs(arr[right] - arr[left]);
                num1 = arr[left];
                num2 = arr[right];
            } else if (currentDiff == closestDiff) {
                int currentPairDiff = Math.abs(arr[right] - arr[left]);
                if (currentPairDiff > maxDiff) {
                    maxDiff = currentPairDiff;
                    num1 = arr[left];
                    num2 = arr[right];
                }
            }

            if (sum < target) {
                left++; // Move left pointer to increase the sum
            } else {
                right--; // Move right pointer to decrease the sum
            }
        }

        result.add(num1);
        result.add(num2);
        Collections.sort(result);
        return result;
    }
}
