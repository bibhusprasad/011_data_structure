package s3_c1_stack;

public class StackByArray {

	int[] arr;
	int topOfStack; // keeps track of the cell which is last occupied in Array, this will help in
					// insertion/deletion

	// createStack
	public StackByArray(final int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: " + size);
	}

	// push
	public void push(final int value) {
		// if array is full, show stack overflow error
		if (this.isStackFull()) {
			System.out.println("Stack overflow error!!");
		} else {
			this.arr[this.topOfStack + 1] = value;
			this.topOfStack++;
			System.out.println("Successfully inserted " + value + " in the stack");
		}
	}

	// peek
	public void peek() {
		if (this.isStackEmpty()) {
			System.out.println("The stack is empty!!");
		} else {
			System.out.println("Top of the stack : " + this.arr[this.topOfStack]);
		}
	}

	// pop
	public void pop() {
		if (this.isStackEmpty()) {
			System.out.println("Stack is Empty.");
		} else {
			System.out.println("Poping value from Stack: " + this.arr[this.topOfStack] + "...");
			this.topOfStack--;
		}
	}

	// delete
	public void deleteStack() {
		this.arr = null;
		System.out.println("Stack is successfully deleted");
	}

	public boolean isStackFull() {
		if (this.topOfStack == this.arr.length - 1) {
			System.out.println("Stack is full !");
			return true;
		} else {
			return false;
		}
	}

	public boolean isStackEmpty() {
		if (this.topOfStack == -1) {
			System.out.println("Stack is Empty !");
			return true;
		} else {
			return false;
		}
	}
}
