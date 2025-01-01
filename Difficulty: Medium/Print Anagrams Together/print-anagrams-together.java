//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            char[] charArray = arr[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if(map.containsKey(s)){
                map.get(s).add(arr[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(s,list);
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(String a : map.keySet()){
            list.add(map.get(a));
        }
        return list;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends