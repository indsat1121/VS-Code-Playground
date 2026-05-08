import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackDequeueFunctions {
    // What is Stack and Dequeue
    // A stack is a data structure that follows the Last In, First Out (LIFO) principle. 
    // It allows adding and removing elements from only one end, called the top of the stack. 
    // The main operations of a stack are push (to add an element), pop (to remove the top element), and top (to peek at the top element without removing it).
    // A deque (double-ended queue) is a data structure that allows adding and removing elements from both ends.
    // Implementing a stack using a deque (double-ended queue)
    // The stack operations (push, pop, top) are implemented using the deque's methods.
    // The push operation adds an element to the front of the deque,
    // the pop operation removes an element from the front of the deque,
    // and the top operation peeks at the front of the deque.
    // The isEmpty method checks if the stack (deque) is empty.
    // This implementation allows us to use the deque as a stack while maintaining the LIFO (Last In, First Out) property of a stack.
    // The time complexity of each operation (push, pop, top, isEmpty) is O(1) since we are using the deque's methods that operate in constant time.
    // The space complexity is O(n) in the worst case, where n is the number of elements in the stack, since we are storing all the elements in the deque.
    // Overall, this implementation provides a simple and efficient way to use a deque as a stack, allowing us to perform stack operations while leveraging the capabilities of the deque data structure.
    // Add PSVM to test this implementation
    //Now Implement common Stack Interview questions
    // 1. Implement a stack using an array.
    // 2. Implement a stack using a linked list.
    // 3. Implement a stack that supports getMin() and getMax() in O(1) time.
    // Now Implement common Dequeue Interview questions
    // 1. Implement a deque using an array.
    // 2. Implement a deque using a linked list.
    // 3. Implement a circular deque.
    // 4. Implement a deque that supports getMin() and getMax() in O(1) time.

    public static void main(String[] args) {
        StackDequeueFunctions stack = new StackDequeueFunctions();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element after pop: " + stack.top()); // Should print 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all elements? " + stack.isEmpty()); // Should print true
        implementStackUsingArray();
        implementStackUsingLinkedList();
        implementStackWithMinMax();
        implementDequeUsingArray();
        implementDequeUsingLinkedList();
        implementCircularDeque();
        implementDequeWithMinMax();

    }

    private Deque<Integer> stack;
    public StackDequeueFunctions() {
        stack = new LinkedList<>();
    }
    public void push(int x) {
        stack.addFirst(x); // Add to the front of the deque
    }
    public int pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.removeFirst(); // Remove from the front of the deque
    }
    public int top() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty"); 
        }
        return stack.peekFirst(); // Peek at the front of the deque
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    //Now Implement common Stack Interview questions
    // Write a function and call from PSVM to implement a stack using an array.
    // The function will create a stack, perform some operations, and print the results to demonstrate the functionality of the stack implemented using an array.
    // The function will create an instance of the StackUsingArray class, which is defined as a static inner class within the StackDequeueFunctions class.
    // The StackUsingArray class has methods for push, pop, top, and isEmpty operations, which are used to manipulate the stack implemented using an array.
    // The function will perform a series of operations on the stack, such as pushing elements onto the stack, popping elements from the stack, and checking the top element and whether the stack is empty.
    // The results of these operations will be printed to the console to demonstrate the functionality of the stack implemented using an array.
    // The function will also handle edge cases, such as popping from an empty stack or peeking at the top element of an empty stack, by throwing appropriate exceptions.
    // Overall, this function will serve as a test case to validate the implementation of the stack using an array and to showcase how the stack operations work in practice.
    public static void implementStackUsingArray() {
        StackUsingArray stack = new StackUsingArray(10); // Create a stack with capacity 10
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element after pop: " + stack.top()); // Should print 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all elements? " + stack.isEmpty()); // Should print true
    }  
    
    static class StackUsingArray {
        private int[] arr;
        private int top;

        public StackUsingArray(int capacity) {
            arr = new int[capacity];
            top = -1;
        }

        public void push(int x) {
            if (top == arr.length - 1) {
                throw new StackOverflowError("Stack is full");
            }
            arr[++top] = x;
        }

        public int pop() {
            if (top == -1) {
                throw new NoSuchElementException("Stack is empty");
            }
            return arr[top--];
        }

        public int top() {
            if (top == -1) {
                throw new NoSuchElementException("Stack is empty");
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // 2. Implement a stack using a linked list.

    public static void implementStackUsingLinkedList() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element after pop: " + stack.top()); // Should print 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all elements? " + stack.isEmpty()); // Should print true
    }

    static class StackUsingLinkedList {
        private Node head;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (head == null) {
                throw new NoSuchElementException("Stack is empty");
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public int top() {
            if (head == null) {
                throw new NoSuchElementException("Stack is empty");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    // 3. Implement a stack that supports getMin() and getMax() in O(1) time.

    public static void implementStackWithMinMax() {
        StackWithMinMax stack = new StackWithMinMax();
        stack.push(3);
        stack.push(5);
        System.out.println("Current Min: " + stack.getMin()); // Should print 3
        System.out.println("Current Max: " + stack.getMax()); // Should print 5
        stack.push(2);
        stack.push(1);
        System.out.println("Current Min: " + stack.getMin()); // Should print 1
        System.out.println("Current Max: " + stack.getMax()); // Should print 5
        stack.pop();
        System.out.println("Current Min after pop: " + stack.getMin()); // Should print 2
        System.out.println("Current Max after pop: " + stack.getMax()); // Should print 5
    }
    static class StackWithMinMax {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;
        private Deque<Integer> maxStack;

        public StackWithMinMax() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            maxStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
            if (val == maxStack.peek()) {
                maxStack.pop();
            }
            return val;
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return minStack.peek();
        }

        public int getMax() {
            if (maxStack.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return maxStack.peek();
        }
    }

    // Now Implement common Dequeue Interview questions
    // 1. Implement a deque using an array.
    // 2. Implement a deque using a linked list.
    // 3. Implement a circular deque.
    // 4. Implement a deque that supports getMin() and getMax() in O(1) time.
    // Write a function and call from PSVM to implement a deque using an array.
    // The function will create a deque, perform some operations, and print the results to demonstrate the functionality of the deque implemented using an array.
    // The function will create an instance of the DequeUsingArray class, which is defined as a static inner class within the StackDequeueFunctions class.
    // The DequeUsingArray class has methods for addFirst, addLast, removeFirst, removeLast, getFirst, getLast, isEmpty operations, which are used to manipulate the deque implemented using an array.
    // The function will perform a series of operations on the deque, such as adding elements to the front and back of the deque, removing elements from the front and back of the deque, and checking the first and last element and whether the deque is empty.
    // The results of these operations will be printed to the console to demonstrate the functionality of the deque implemented using an array.
    // The function will also handle edge cases, such as removing from an empty deque or peeking at the first and last element of an empty deque, by throwing appropriate exceptions.
    // Overall, this function will serve as a test case to validate the implementation of the deque using an array and to showcase how the deque operations work in practice.   
    public static void implementDequeUsingArray() {
        DequeUsingArray deque = new DequeUsingArray(10);
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("First element: " + deque.getFirst()); // Should print 3
        System.out.println("Last element: " + deque.getLast()); // Should print 4
    }
    static class DequeUsingArray {
        private int[] arr;
        private int front;
        private int rear;
        private int size;

        public DequeUsingArray(int capacity) {
            arr = new int[capacity];
            front = -1;
            rear = 0;
            size = 0;
        }

        public void addFirst(int x) {
            if (size == arr.length) {
                throw new IllegalStateException("Deque is full");
            }
            if (front == -1) {

                front = 0;
            }
            arr[front] = x;
            size++;
        }

        public void addLast(int x) {
            if (size == arr.length) {
                throw new IllegalStateException("Deque is full");
            }
            if (rear == -1) {
                rear = 0;
            }
            arr[rear] = x;
            size++;
        }

        public int removeFirst() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            int val = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return val;
        }
        public int removeLast() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            int val = arr[rear];
            rear = (rear - 1) % arr.length;
            size--;
            return val;
        }
        public int getFirst() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            return arr[front];
        }
        public int getLast() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            return arr[rear];
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }

    // 2. Implement a deque using a linked list.
    public static void implementDequeUsingLinkedList() {
        DequeUsingLinkedList deque = new DequeUsingLinkedList();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("First element: " + deque.getFirst()); // Should print 3
        System.out.println("Last element: " + deque.getLast()); // Should print 4
    }
    static class DequeUsingLinkedList {
        private Node head;
        private Node tail;

        private static class Node {
            int data;
            Node next;
            Node prev;
    
            Node(int data) {
                this.data = data;
            }
        }

        public void addFirst(int x) {
            Node newNode = new Node(x);
            newNode.next = head;
            newNode.prev = null;
    
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        }

        public void addLast(int x) {
            Node newNode = new Node(x);
            newNode.next = null;
            newNode.prev = tail;

            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        }

        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("Deque is empty");
            }
            int val = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return val;
        }

        public int removeLast() {
            if (tail == null) {
                throw new IllegalStateException("Deque is empty");
            }
            int val = tail.data;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            return val;
        }

        public int getFirst() {
            if (head == null) {
                throw new IllegalStateException("Deque is empty");
            }
            return head.data;
        }
        public int getLast() {
            if (tail == null) {
                throw new IllegalStateException("Deque is empty");
            }
            return tail.data;
        }
        public boolean isEmpty() {
            return head == null;
        }
    }

    // 3. Implement a circular deque.
    public static void implementCircularDeque() {
        CircularDeque deque = new CircularDeque(10);
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("First element: " + deque.getFirst()); // Should print 3
        System.out.println("Last element: " + deque.getLast()); // Should print 4
    }
    static class CircularDeque {
        private int[] arr;
        private int front;
        private int rear;
        private int size;

        public CircularDeque(int capacity) {
            arr = new int[capacity];
            front = -1;
            rear = 0;
            size = 0;
        }   
        public void addFirst(int x) {
            if (size == arr.length) {
                throw new IllegalStateException("Deque is full");
            }
            if (front == -1) {
                front = 0;
            }
            arr[front] = x;
            size++;
        }
        public void addLast(int x) {        
            if (size == arr.length) {
                throw new IllegalStateException("Deque is full");
            }
            if (rear == -1) {
                rear = 0;
            }
            arr[rear] = x;
            size++;
        }
        public int removeFirst() {
            if (size == 0) {        
                throw new IllegalStateException("Deque is empty");
            }
            int val = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return val;
        }
        public int removeLast() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            int val = arr[rear];
            rear = (rear - 1 + arr.length) % arr.length;
            size--;
            return val;
        }
        public int getFirst() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            return arr[front];
        }
        public int getLast() {
            if (size == 0) {
                throw new IllegalStateException("Deque is empty");
            }
            return arr[rear];
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }
    // 4. Implement a deque that supports getMin() and getMax() in O(1) time.
    public static void implementDequeWithMinMax() {
        DequeWithMinMax deque = new DequeWithMinMax();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("First element: " + deque.getFirst()); // Should print 3
        System.out.println("Last element: " + deque.getLast()); // Should print 4
    }
    static class DequeWithMinMax {
        private Deque<Integer> deque;
        private Deque<Integer> minDeque;
        private Deque<Integer> maxDeque;

        public DequeWithMinMax() {
            deque = new LinkedList<>();
            minDeque = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }
        public void addFirst(int x) {
            deque.addFirst(x);
            minDeque.addFirst(minDeque.isEmpty() ? x : Math.min(x, minDeque.peekFirst()));
            maxDeque.addFirst(maxDeque.isEmpty() ? x : Math.max(x, maxDeque.peekFirst()));
        }

        public void addLast(int x) {
            deque.addLast(x);
            minDeque.addLast(minDeque.isEmpty() ? x : Math.min(x, minDeque.peekLast()));
            maxDeque.addLast(maxDeque.isEmpty() ? x : Math.max(x, maxDeque.peekLast()));
        }

        public int removeFirst() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            minDeque.removeFirst();
            maxDeque.removeFirst();
            return deque.removeFirst();
        }

        public int removeLast() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            minDeque.removeLast();
            maxDeque.removeLast();
            return deque.removeLast();
        }

        public int getFirst() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.peekFirst();
        }

        public int getLast() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public int getMin() {
            if (minDeque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return Math.min(minDeque.peekFirst(), minDeque.peekLast());
        }

        public int getMax() {
            if (maxDeque.isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return Math.max(maxDeque.peekFirst(), maxDeque.peekLast());
        }
    }

}
