import java.lang.Math;

/**
 * In this program, we are given two linked lists, each representing a non-negative integer.
 * Each node contains a single digit, and the digits are stored in reverse order. In this 
 * program, I will add the two numbers and will return the sum as a linked list with digits
 * stored in reverse order.
 *
 * @param l1 The first number to be added, stored as a linked list
 * @param l2 The second number to be added, stored as a linked list
 * @return The sum of the two parameters, also stored as a linked list
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Creating the head node of the sum 
        ListNode head = new ListNode (0, null);
        ListNode p = head; // Pointer node
        
        // Creating a variable to represent if the sum is greater than 10
        boolean above10 = false;
        
        // Building the linked list
        int sum = 0; //sum of values in l1 and l2
        while (l1 != null ||  l2 != null || above10 == true){
            if (l1 != null){
                sum += l1.val; //adding l1's value to sum
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val; //adding l2's value to sum
                l2 = l2.next;
            }
            if (above10 == true){
                sum += 1; //adding 1 to sum if the sum of the previous values was above 10
            }
            ListNode lNew = new ListNode (sum % 10, null); //creating the new node
            if (sum < 10){ //checking if the sum is above 10
                above10 = false;
            } else {
                above10 = true;
            }
            p.next = lNew; //setting the next node to be the new one
            p = p.next; //setting the node pointer to the new one
            sum = 0; //resetting the sum
        }
        return head.next; //returning the node after head, since head contains an extra 0
    }
}
