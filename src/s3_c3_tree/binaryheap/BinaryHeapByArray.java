package s3_c3_tree.binaryheap;

public class BinaryHeapByArray {

	int[] arr;
	int sizeOfTree;

	// Constructor
	public BinaryHeapByArray(final int size) {
		// We are adding 1 here so that first cell of the array can be left blank all
		// the time. This is eliminate problem of array starting from index 0.
		this.arr = new int[size + 1];
		this.sizeOfTree = 0;
		System.out.println("Empty Heap has been created !");
	}

	// Insert a new value in Heap
	public void insertInHeap(final int value) {
		// Doing +1 because sizeOfTree always points to the last occupied cell of the
		// array
		System.out.println("Inserting " + value + " in Heap...");
		this.arr[this.sizeOfTree + 1] = value;
		this.sizeOfTree++;
		this.heapifyBottomToTop(this.sizeOfTree);
		System.out.println("Inserted " + value + " successfully in Heap !");
		this.levelOrder();
	}

	private void heapifyBottomToTop(final int index) {
		final int parent = index / 2;
		// We are at root of the tree. Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		// If Current value is smaller than its parent, then we need to swap
		if (this.arr[index] < this.arr[parent]) {
			final int tmp = this.arr[index];
			this.arr[index] = this.arr[parent];
			this.arr[parent] = tmp;
		}
		this.heapifyBottomToTop(parent);
	}

	private void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= this.sizeOfTree; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println("\n");
	}

	// Extract Head of Heap
	public int extractHeadOfHeap() {
		if (this.sizeOfTree == 0) {
			System.out.println("Heap is empty !");
			return -1;
		} else {
			System.out.println("Head of the Heap is: " + this.arr[1]);
			System.out.println("Extracting it now...");
			final int extractedValue = this.arr[1];
			this.arr[1] = this.arr[this.sizeOfTree];
			this.sizeOfTree--;
			this.heapifyTopToBottom(1);
			System.out.println("Successfully extracted value from Heap.");
			this.levelOrder();
			return extractedValue;
		}
	}

	private void heapifyTopToBottom(final int index) {
		final int left = index * 2;
		final int right = (index * 2) + 1;
		int smallestChild = 0;
		if (this.sizeOfTree < left) { // If there is no child of this node, then nothing to do. Just return.
			return;
		} else if (this.sizeOfTree == left) { // If there is only left child of this node, then do a comparison and
												// return.
			if (this.arr[index] > this.arr[left]) {
				final int tmp = this.arr[index];
				this.arr[index] = this.arr[left];
				this.arr[left] = tmp;
			}
			return;
		} else { // If both children are there
			if (this.arr[left] < this.arr[right]) { // Find out the smallest child
				smallestChild = left;
			} else {
				smallestChild = right;
			}
			if (this.arr[index] > this.arr[smallestChild]) { // If Parent is greater than smallest child, then swap
				final int tmp = this.arr[index];
				this.arr[index] = this.arr[smallestChild];
				this.arr[smallestChild] = tmp;
			}
		}
		this.heapifyTopToBottom(smallestChild);
	}

	public int sizeOfArray() {
		return this.arr.length;
	}

	public int sizeOfTree() {
		System.out.println("Size Of Tree: " + this.sizeOfTree);
		return this.sizeOfTree;
	}

	public boolean isHeapEmpty() {
		if (this.sizeOfTree <= 0) {
			System.out.println("Tree is empty !");
			return true;
		} else {
			System.out.println("Tree is not empty !");
			return false;
		}
	}

	public void deleteHeap() {
		this.arr = null;
		System.out.println("Heap has been deleted !");
	}

	public void peek() {
		if (this.sizeOfTree == 0) {
			System.out.println("Heap is empty !");
		} else {
			System.out.println("Head of the Heap is: " + this.arr[1]);
		}
	}

}
