/*
Leetcode 21: Merge two sorted linked lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ptr.next = new ListNode(list1.val); 
                ptr = ptr.next;
                list1 = list1.next;
            }
            else{
                ptr.next = new ListNode(list2.val);
                ptr = ptr.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            ptr.next = new ListNode(list1.val);
            ptr = ptr.next;
            list1 = list1.next;
        }
        while(list2 != null){
            ptr.next = new ListNode(list2.val);
            ptr = ptr.next;
            list2 = list2.next;
        }
        return result.next;
    }
    public static ListNode takeInput(Scanner scanner, String listName) {
        System.out.print("Enter number of nodes for " + listName + ": ");
        int n = scanner.nextInt();
        if (n <= 0) return null;
        System.out.println("Enter sorted values for " + listName + ":");
        int firstVal = scanner.nextInt();
        ListNode head = new ListNode(firstVal);
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeSortedLists solution = new MergeSortedLists();
        ListNode list1 = takeInput(scanner, "List 1");
        ListNode list2 = takeInput(scanner, "List 2");
        System.out.println("\nOriginal List 1:");
        printList(list1);
        System.out.println("Original List 2:");
        printList(list2);
        ListNode resultHead = solution.mergeTwoLists(list1, list2);
        System.out.println("\nMerged Sorted List:");
        printList(resultHead);
        scanner.close();
    }
}