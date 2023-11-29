Intuition
When I encountered this problem, I tried solving it by revising the whole linked list first and move forward a pointer k times. Then, I broke the linked list at [k] and reverse the first half and the second half of the linked list. Lastly, I tried putting the two halvs together but I ran into some issues. The solution also got overly complicated so I tried a different approach that is much more simpler and efficient which I will be showing you today.

Approach
The basic idea of the solution that I am about to implement is quite simple but there are some clever tricks into it. We first need to find the length of the linked list that we are given to and then we would subtract k from the length. There are some caveat to k which I will further explain. Then we move a pointer however many steps that (length - k) gave us. We would break the linked list at where the pointer stop. Lastly, we will take the second part of the broken linked list and connect that to the first part of the linked list.

1) Add Bases
First, we check lf the linked list that we are given is empty or if k is 0. If one or more conditions are met, we can just return the head since there are noting that we need to do

    if (head == null || k == 0) {
            return head;
        }
2) Find the Length of the Given Linked List
In order to know where we want to break the linked list, we first need to know how long the linked list is. We can find that by simply implementing a basic while loop that traverse the linked list and adding one in each iteration to a variable that I initialized named length

     ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
3) The Special k
The key part of the algorithm is what we do with k:

First, we need to understand that if k == length, then by taking each of the last elements and putting it in the front will give us what we beginned with.
Let's say:
a --> b --> c --> d length = 4 k=4
If you rotate it k times, you will end up with:
rotate 1: d --> a --> b --> c
rotate 2: c --> d --> a --> b
rotate 3: b --> c --> d --> a
rotate 4: a --> b --> c --> d
Therefore, there is no point rotating it four times to where we begun with. We an just simply return the original linked list

Secondly, we can mod k by length:
k % length
if k < length, the result of the mod will just be k
i.e) 4%10 = 4
if k == length, the result of the mod will be 0 since k is divisible by length
i.e) 10%10 = 0, 20%10 = 0
If k is not divisible by length, then it will output the remainder
i.e) 10%3 = 1

The point of doing this is that we don't need to rotate a linked list k times If k is divisible by length. If k is not divisible by length, we only need to rotate the linked list the remainder of times that we calculated using the mod operator. Take the example of a-->b-->c, k=4. We don't actually need to rotate the linked list four times because doing the first three times will just reusult in a linked list that we stared off with. Therefore we really only need to rotate it one time, which is going to make a difference.

        if (k == length) {
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
5) The Number of Times to Move Forward
This part is fairly straitht forward. But I want to point out the reason why we subtract 1 from go. We want to stop one position before where we need to break our list because I want to properly end the first part of the list by pointing its last node to none. Before that though, I am going to assign a pointer(nextFirst) to the first node of the seocnd linked list so I don't lose them.

There is an edge case that I encountered where the length of the linked list would be 1 and we can't rotate it with anything if there is only one node in the linked list so we will just return head

        int go = length - k;
        ListNode first = head;
        for (int i = 0; i < go - 1; i++) {
            first = first.next;
        }
        ListNode nextFirst = first.next;
        first.next = null;
        if (length == 1) {
            return head;
        }
5) Connect Two Parts
Now, we will iterate through the second part of the linked list and when it reaches the last node, we will point that to the first node of the first part of the linked list (head). Lastly, we will return nextFirst which is the new begining of our linked list.

        ListNode tail = nextFirst;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return nextFirst;
Complexity
Time complexity:
We are iterating through the linked list one time in the beginning of our algorithm so that would give us O(n) time complexity.
We also tried finding a node in which we can use as the new head of the second linked list and break the original linked list into two parts. The number times to move forward to find the new head is determined by k so the time complexity would be O(k)

Overall, the time complexity is O(n + k), where n is the number of nodes in the linked list.

Space complexity:
The algorithm uses a constant amount of extra space, except for the input and output. It does not use any additional data structures that grow with the input size. Therefore, the space complexity is O(1).
Code

  class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // base case
        if (head == null || k == 0) {
            return head;
        }

        // length of the linked list
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        // special k
        if (k == length) {
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }

        // the number of times to move forward
        int go = length - k;
        ListNode first = head;
        for (int i = 0; i < go - 1; i++) {
            first = first.next;
        }
        ListNode nextFirst = first.next;
        first.next = null;
        if (length == 1) {
            return head;
        }

        // connect two parts
        ListNode tail = nextFirst;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return nextFirst;
    }
}
