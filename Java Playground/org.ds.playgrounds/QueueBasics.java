import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueBasics {

    // Simple queue wrapper to show FIFO operations.
    static class IntQueue {
        private final Queue<Integer> queue = new ArrayDeque<>();

        // enqueue / offer: add element to back
        // Time: O(1), Space: O(1) extra
        public void enqueue(int value) {
            queue.offer(value);
        }

        // dequeue / poll: remove and return front element
        // Time: O(1), Space: O(1) extra
        public int dequeue() {
            Integer value = queue.poll();
            if (value == null) {
                throw new NoSuchElementException("Queue is empty");
            }
            return value;
        }

        // peek: read front element without removing
        // Time: O(1), Space: O(1)
        public int peek() {
            Integer value = queue.peek();
            if (value == null) {
                throw new NoSuchElementException("Queue is empty");
            }
            return value;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public int size() {
            return queue.size();
        }
    }

    // Basic interview-style use case:
    // process tasks in arrival order (FIFO).
    // Time: O(n), Space: O(n)
    public static void processTasksInOrder(String[] tasks) {
        Queue<String> taskQueue = new ArrayDeque<>();
        for (String task : tasks) {
            taskQueue.offer(task);
        }

        while (!taskQueue.isEmpty()) {
            String next = taskQueue.poll();
            System.out.println("Processing: " + next);
        }
    }

    public static void main(String[] args) {
        IntQueue queue = new IntQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front after dequeue: " + queue.peek());
        System.out.println("Current size: " + queue.size());

        String[] tasks = {"Email", "Compile", "Deploy"};
        processTasksInOrder(tasks);
    }
}
