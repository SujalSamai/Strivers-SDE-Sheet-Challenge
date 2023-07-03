### Question
- Given the head of a linked list, rotate the list to the right by k places.

### Sample Input
    head = [1,2,3,4,5], k = 2
    head = [0,1,2], k = 4

### Sample Output
    [4,5,1,2,3]
    [2,0,1]

### Solution
- Calculate the length of the list. 
- Connect the last node to the first node, converting it to a circular linked list. 
- Iterate to cut the link of the last node and start a node of k%length of the list rotated list.

### Code
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        ListNode temp=head;
        int length=1;
        //find length of linked list
        while (temp.next!=null){
            ++length;
            temp=temp.next;
        }

        //join last node with head
        temp.next=head;
        //when k is more than length
        k=k%length;

        //find after where we have to rotate, or to get end of the result list
        int end=length-k;
        while (end!=0){
            temp=temp.next;
            end--;
        }
        //pointing head to the breaking node
        head=temp.next;
        //making end node pointing to null
        temp.next=null;
        return head;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)