package Stacks_Queues.StackUsingArr;

public class Code {
    static class Stack {
        int[] st;
        int top;
        int cap;
        Stack(int capacity) {
            this.top=-1;
            st=new int[capacity];
            this.cap = capacity;
        }
        public void push(int num) {
            if(cap-top > 1){
                top++;
                st[top]= num;
            }
        }
        public int pop() {
            if (top>=0){
                int x = st[top];
                top--;
                return x;
            }else return -1;
        }
        public int top() {
            if (top>=0){
                return st[top];
            }else return -1;
        }
        public int isEmpty() {
            if (top==-1) return 1;
            else return 0;
        }
        public int isFull() {
            if (top==cap-1) return 1;
            else return 0;
        }
    }
}
