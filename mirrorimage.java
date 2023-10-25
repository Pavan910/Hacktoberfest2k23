
import java.util.*;

class Solution {

    static Node reverse(Node x) {
        // your code goes here
        Node prev = null;
        Node curr = x;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node addTwoLists(Node first, Node second) {

        first = reverse(first);
        second = reverse(second);

        Node sum = null;
        int carry = 0;

        while (first != null || second != null || carry > 0) {

            int newVal = carry;

            if (first != null)
                newVal += first.data;
            if (second != null)
                newVal += second.data;

            carry = newVal / 10;

            newVal = newVal % 10;

            Node newNode = new Node(newVal);

            newNode.next = sum;

            sum = newNode;

            if (first != null)
                first = first.next;
            if (second != null)
                second = second.next;
        }

        return sum;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class mirrorimage {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
