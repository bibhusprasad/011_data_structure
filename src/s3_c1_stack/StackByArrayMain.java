package s3_c1_stack;

public class StackByArrayMain {

    public static void main(final String[] args) {
        System.out.println("Creating a stack of size 5...");
        final StackByArray stack = new StackByArray(5);

        System.out.println("Pushing 6 values in the Stack...");
        for (int i = 0; i <= 5; i++) {
            stack.push(i * 10);
        }

        System.out.println("Peeking value from stack");
        stack.peek();

        System.out.println("Poping 6 values from the Stack...");
        for (int i = 0; i <= 5; i++) {
            stack.pop();
        }

        System.out.println("Deleting the Stack...");
        stack.deleteStack();
    }
}
