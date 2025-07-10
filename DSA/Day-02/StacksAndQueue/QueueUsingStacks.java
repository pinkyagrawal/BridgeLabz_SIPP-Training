import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>(); // for enqueue
    Stack<Integer> stack2 = new Stack<>(); // for dequeue

    // Enqueue operation (O(1))
    public void enqueue(int x) {
        stack1.push(x);
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation (Amortized O(1), worst O(n))
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front of queue: " + queue.peek()); // 10
        System.out.println("Dequeued: " + queue.dequeue());     // 10

        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue());     // 20
        System.out.println("Dequeued: " + queue.dequeue());     // 30
        System.out.println("Dequeued: " + queue.dequeue());     // 40

        System.out.println("Queue empty? " + queue.isEmpty());  // true
    }
}
