// Implement Common Linked List Functions in Java and also
// include a main method to demonstrate the functionality of these functions.
// Also common LinkedList Coding Questions with their solutions, Compexity Analysis and Explanation.

import java.util.LinkedList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LinkedListFunctions {

    public static void main(String[] args) {
        // Create a linked list and demonstrate the functionality of the functions
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original Linked List:");
        printList(linkedList);

        System.out.println("\nReversed Linked List:");
        reverse(linkedList);
        printList(linkedList);

        System.out.println("\nMiddle Element of the Linked List:");
        System.out.println(findMiddle(linkedList));

        System.out.println("\nRemoving duplicates from the Linked List:");
        linkedList.add(3); // Adding a duplicate element
        removeDuplicates(linkedList);
        printList(linkedList);

        System.out.println("\nFinding the length of the Linked List:");
        System.out.println(length(linkedList));
    }

    public static void printList(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void reverse(LinkedList<Integer> list) {
        Collections.reverse(list);
    }
    // Time Complexity: O(n) - We need to traverse the entire list to reverse it.
    // Space Complexity: O(1) - We are reversing the list in place without using
    public static int findMiddle(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Cannot find middle of an empty list");
        }
        return list.get(list.size() / 2);
    }
    // Time Complexity: O(1) - Accessing the middle element is done in constant time.
    // Space Complexity: O(1) - We are not using any additional space to find
    // the middle element.
    public static void removeDuplicates(LinkedList<Integer> list) {
        Set<Integer> seen = new HashSet<Integer>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (!seen.add(value)) {
                iterator.remove();
            }
        }
    }

    public static int length(LinkedList<Integer> list) {
        return list.size();
    }

    // Time Complexity: O(n) - We need to traverse the entire list to remove duplicates.
    // Space Complexity: O(n) - We are using a HashSet to store seen elements, which in the worst case can store all elements of the list.
    // What are the other Linkedlist problems that can be solved using these functions?
    // 1. Finding and removing the nth node from the end of the linked list.
    // 2. Detecting a cycle in the linked list.
    // 3. Merging two sorted linked lists.
    // Implement these Problems with their solutions, complexity analysis and explanations in the same class.

    //Implementing the function to remove the nth node from the end of the linked list
    // Time Complexity: O(n) - We need to traverse the list to find the nth node from the end.
    // Space Complexity: O(1) - We are not using any additional space to remove the nth node from the end.
    public static void removeNthFromEnd(LinkedList<Integer> list, int n) {
        if (n <= 0 || n > list.size()) {
            throw new IllegalArgumentException("Invalid value of n: " + n);
        }
        int indexToRemove = list.size() - n;
        list.remove(indexToRemove);
    }

    //Implementing the function to find the nth node from the end of the linked list
    // Time Complexity: O(n) - We need to traverse the list to find the nth node from the end.
    // Space Complexity: O(1) - We are not using any additional space to find the nth node from the end.
    public static int findNthFromEnd(LinkedList<Integer> list, int n) {
        if (n <= 0 || n > list.size()) {
            throw new IllegalArgumentException("Invalid value of n: " + n);
        }
        return list.get(list.size() - n);
    }
    // Implementing the function to detect a cycle in the linked list
    // Time Complexity: O(n) - We need to traverse the list to detect a cycle
    // Space Complexity: O(n) - We are using a HashSet to store seen nodes, which in the worst case can store all nodes of the list.
    public static boolean hasCycle(LinkedList<Integer> list) {
        Set<Integer> seen = new HashSet<Integer>();
        for (Integer value : list) {
            if (!seen.add(value)) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle detected
    }   

    // Implementing the function to merge two sorted linked lists
    // Time Complexity: O(n + m) - We need to traverse both lists to merge
    // Space Complexity: O(n + m) - We are creating a new list to store the merged result, which in the worst case can store all elements of both lists.
    public static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> mergedList = new LinkedList<Integer>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }   
        return mergedList;
    }









}
