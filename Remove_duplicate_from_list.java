Intuition
The problem requires removing duplicates from a sorted singly-linked list. The approach involves iterating through the list and removing duplicates while maintaining the sorted order.

Approach
Initialize a pointer current to the head of the linked list to traverse the list.
Start a while loop that continues until current reaches the end of the list or current.next reaches null.
Inside the loop, compare the value of the current node current.val with the value of the next node current.next.val.
If the values are equal, it indicates a duplicate node. In this case, update the next pointer of the current node current.next to skip the next node (remove the duplicate).
If the values are not equal, move the current pointer to the next node, continuing the traversal.
Repeat the loop until the end of the list is reached, ensuring that all duplicates are removed while maintaining the sorted order of the remaining nodes.
After the loop, return the modified linked list, which contains no duplicates.
Complexity
Time complexity: O(n)
The algorithm iterates through the linked list once, where n is the number of nodes in the list. Each node is examined once to identify and remove duplicates.

Space complexity: O(1)
The algorithm uses a constant amount of additional memory space for variables, regardless of the size of the input linked list, making its space complexity constant.

Code
class Solution {
   public ListNode deleteDuplicates(ListNode head) {
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
}
