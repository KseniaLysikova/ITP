import java.util.NoSuchElementException;

public class Stack<T> {
    private T[] array;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full.");
        }
        array[++top] = item;
    }

    public T pop() {
        if (top == -1) {
            throw  new NoSuchElementException("Stack is empty.");
        }
        return array[top--];
    }

    public T peek() {
        if (top == -1) {
            throw  new NoSuchElementException("Stack is empty.");
        }
        return array[top];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // Выводит 3
        System.out.println(stack.pop()); // Выводит 3
        System.out.println(stack.pop()); // Выводит 2
        System.out.println(stack.pop()); // Выводит 1
    }
}
