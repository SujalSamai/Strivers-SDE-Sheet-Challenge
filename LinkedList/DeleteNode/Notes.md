### Question
- There is a singly-linked list head and we want to delete a node node in it. 
- You are given the node to be deleted node. You will not be given access to the first node of head. 
- All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list. 
- Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
  - The value of the given node should not exist in the linked list. 
  - The number of nodes in the linked list should decrease by one. 
  - All the values before node should be in the same order. 
  - All the values after node should be in the same order.

### Sample Input
    head = [4,5,1,9], node = 5
    head = [4,5,1,9], node = 1

### Sample Output
    [4,1,9]
    [4,5,9]

### Solution
- Here, we are provided directly the node which we have to delete, not the head
- To delete it, we will simply copy the value of the next node to the current node
- and then point its next pointer to next.next

### Code
    public void deleteNode(ListNode node) {
        if(node==null) return;
        node.val=node.next.val;
        node.next= node.next.next;
    }

### Edge Cases
- if node is null, then return as it is

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(1)
2. Space Complexity - O(1)