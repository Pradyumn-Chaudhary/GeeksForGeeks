//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public static int helper(Node node, int carry){
        if(node == null)
        return carry;
        int c = helper(node.next, carry);
        int temp = node.data + c;
        if(temp < 10){
            node.data = temp;
            carry = 0;
        }else{
            node.data = temp - 10;
            carry = 1;
        }
        return carry;
    }
    public Node addOne(Node head) {
        // code here.
        int temp = helper(head, 1);
        if(temp == 1){
            Node temp1 = new Node(1);
            temp1.next = head;
            head = temp1;
        }
        return head;
    }
}
