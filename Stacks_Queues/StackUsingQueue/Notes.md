### Question
- Implement a Stack DS specifically to store integer data using two queues
- There should be two data members, both being Queues to store the data internally
    1. Push(num)
    2. Pop()
    3. Top()
    4. Size()
    5. isEmpty()

### Sample Input
    func=1 add=13
    func=1 add=47
    func=4
    func=5 
    func=2
    func=3

### Sample Output
    2
    false
    47
    13

### Solution
- Queue is implemented using LL in java
- In getSize, return size of q1, in isEmpty(), return if q1 is empty
- To push, we will remove all numbers from q1 and store them in q2, then add given number in q1 and then again push back all the numbers from q2 to q1
- In pop, get the top element and remove it from q1
- In top, just shoe the top of q1

### Code
    static class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public Stack() {
           q1= new LinkedList<>();  //Queue is implemented through LL in java
            q2= new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            if (q1.isEmpty()) return 0;
            else return q1.size();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public void push(int element) {
            while (!q1.isEmpty()) {
                q2.add(q1.element());
                q1.remove();
            }
            q1.add(element);
            while (!q2.isEmpty()) {
                q1.add(q2.element());
                q2.remove();
            }
        }

        public int pop() {
            if (q1.isEmpty()) return -1;
            else{
                int ans= q1.peek();
                q1.poll();
                return ans;
            }
        }

        public int top() {
            if (q1.isEmpty())  return -1;
            else return q1.peek();
        }
    }

### Edge Cases
- NA

### Other Techniques
- We can also do it with one Queue

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)