### Question
- You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. 
- You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Sample Input
    l1 = [2,4,3], l2 = [5,6,4]
    l1 = [0], l2 = [0]
    l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]

### Sample Output
    [7,0,8]
    [0]
    [8,9,9,9,0,0,0,1]

### Solution
- Most important thing is that, to make work easier, we have been given the numbers is reverse order, which means the least significant digit is the head of the list
- Create a new LL, and take a temp to traverse the list, maintain a carry too
- traverse the lists till both of them are not empty, or carry is 1 as, there might one carry remain but no numbers are there so we will need to add 1 at end
- now add sum of both l1, l2 in sum, add carry too if present
- suppose sum=14, calculate the carry=sum/10, our carry will be 1
- if sum is more than 10, so we will add the last digit to our node, node will have=4
- move the temp pointer

### Code
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy= new ListNode();
        ListNode temp= dummy;
        int carry=0;

        while (l1!=null || l2!=null || carry==1){
            int sum=0;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;
            carry=sum/10;
            ListNode node= new ListNode(sum%10);
            temp.next=node;
            temp=temp.next;
        }
        return dummy.next;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(max(M,N))
2. Space Complexity - O(max(M,N))