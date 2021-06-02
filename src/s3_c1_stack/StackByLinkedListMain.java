package s3_c1_stack;

public class StackByLinkedListMain {

	public static void main(final String[] args) {
		final StackByLinkedList stack = new StackByLinkedList();

		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			System.out.println(stack.pop());
		}
		System.out.println();
		stack.deleteStack();
	}
}
