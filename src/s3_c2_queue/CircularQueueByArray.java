package s3_c2_queue;

public class CircularQueueByArray {
	int[] arr;
	int topOfQueue;
	int size;
	int beginningOfQueue;

	public CircularQueueByArray(final int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.println("Successfully created an empty queue of size: " + size);
	}

	public void enQueue(final int value) {
		if (this.arr == null) {
			System.out.println("Array is not yet created. Please create one first.");
		} else if (this.isQueueFull()) {
			System.out.println("\nQueue overflow error!!");
		} else {
			this.initializeStartOfArray();
			if (this.topOfQueue + 1 == this.size) { // if top is already at last cell of array, then reset it to first
													// cell
				this.topOfQueue = 0;
			} else {
				this.topOfQueue++;
			}
			this.arr[this.topOfQueue] = value;
			System.out.println("\nSuccessfully inserted " + value + " in the queue");
		}
	}

	public void initializeStartOfArray() {
		if (this.beginningOfQueue == -1) {
			this.beginningOfQueue = 0;
		}
	}

	public void deQueue() {
		if (this.isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("\n---------------------------------------------");
			System.out.println("Before Dequeue..");
			this.printArray();
			System.out.println("\nDequeing value from Queue...");
			System.out.println("Dequeued: " + this.arr[this.beginningOfQueue] + " from queue");
			this.arr[this.beginningOfQueue] = 0; // initialize the unused cell to 0
			if (this.beginningOfQueue == this.topOfQueue) { // if there is only 1 element in Queue
				this.beginningOfQueue = this.topOfQueue = -1;
			} else if (this.beginningOfQueue + 1 == this.size) { // if start has reached end of array, then start again
																	// from 0
				this.beginningOfQueue = 0;
			} else {
				this.beginningOfQueue++;
			}
		}
		System.out.println("After Dequeue..");
		this.printArray();
		System.out.println("---------------------------------------------");
	}

	public boolean isQueueEmpty() {
		return this.topOfQueue == -1;
	}

	public boolean isQueueFull() {
		if (this.topOfQueue + 1 == this.beginningOfQueue) { // If we have completed a circle, then we can say that Queue
															// is full
			return true;
		} else if ((this.beginningOfQueue == 0) && (this.topOfQueue + 1 == this.size)) { // Trivial case of Queue being
																							// full
			return true;
		} else {
			return false;
		}
	}

	public void peekOperation() {
		// if stack is not empty, return the value on top of stack
		if (!this.isQueueEmpty()) {
			System.out.println("\nPeeking value from queue...");
			System.out.println(this.arr[this.beginningOfQueue]);
		} else {
			System.out.println("The queue is empty!!");
		}
	}

	public void deleteStack() {
		System.out.println("\n\nDeleting the entire Queue...");
		this.arr = null;
		System.out.println("Queue is successfully deleted !");
	}

	public void printArray() {
		System.out.println("Array now...");
		for (int i = 0; i < this.size; i++) {
			System.out.print(this.arr[i] + "  ");
		}
		System.out.println("\nStart = " + this.beginningOfQueue);
		System.out.println("End = " + this.topOfQueue);
	}
}
