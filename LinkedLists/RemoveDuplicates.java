/*
Leetcode 83: Remove duplicates from sorted list
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveDuplicates {
    static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes (n): ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("List is empty.");
            scanner.close();
            return;
        }
        System.out.println("Enter sorted values:");
        int firstVal = scanner.nextInt();
        ListNode head = new ListNode(firstVal);
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next; 
        }
        System.out.print("Original List: ");
        printList(head);
        ListNode resultHead = deleteDuplicates(head);
        System.out.print("List after removing duplicates: ");
        printList(resultHead);
        scanner.close();
    }
}
