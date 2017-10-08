import java.util.LinkedList;
import java.util.Queue;

public class Question225ImplementStackusingQueues {
    class MyStack {
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = this.queue.size();
            for (int i = 0; i < size - 1; i += 1) {
                this.queue.add(this.queue.poll());
            }
            int tmp = this.queue.poll();
            return tmp;
        }

        /** Get the top element. */
        public int top() {
            int size = this.queue.size();
            for (int i = 0; i < size - 1; i += 1) {
                this.queue.add(this.queue.poll());
            }
            int tmp = this.queue.poll();
            this.queue.add(tmp);
            return tmp;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.size() == 0;
        }
    }
}
