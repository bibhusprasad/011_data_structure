package s3_c3_tree.binarytree;

public class BinaryTreeByArray {

	private int[] arr;
	private int lastUsedIndex;

	// Constructor for blank Tree
	public BinaryTreeByArray(final int size) {
		this.arr = new int[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size " + size + " has been created !\n");
	}

	// New node should be inserted at the first empty place in the array
	public void insert(final int value) {
		if (!this.isTreeFull()) {
			this.arr[this.lastUsedIndex + 1] = value;
			this.lastUsedIndex++;
			System.out.println("Successfully inserted " + value + " in the tree!");
		} else {
			System.out.println("Could not insert value in the Tree as it is full !");
		}
	}

	// Check if array is full
	private boolean isTreeFull() {
		if (this.arr.length - 1 == this.lastUsedIndex) {
			return true;
		} else {
			return false;
		}
	}

	// Pre-Order traversal of binary tree
	public void preOrder(final int index) {
		if (index > this.lastUsedIndex) {
			return;
		}
		System.out.print(this.arr[index] + " ");
		this.preOrder(index * 2);
		this.preOrder(index * 2 + 1);
	}

	// In-Order Traversal of binary tree
	public void inOrder(final int index) {
		if (index > this.lastUsedIndex) {
			return;
		}
		this.inOrder(index * 2);
		System.out.print(this.arr[index] + " ");
		this.inOrder(index * 2 + 1);
	}

	// Post-Order Traversal of binary tree
	public void postOrder(final int index) {
		if (index > this.lastUsedIndex) {
			return;
		}
		this.postOrder(index * 2);
		this.postOrder(index * 2 + 1);
		System.out.print(this.arr[index] + " ");
	}

	// level-Order traversal of binary tree
	public void levelOrder() {
		for (int i = 1; i <= this.lastUsedIndex; i++) {
			System.out.print(this.arr[i] + " ");
		}
	}

	// Do a linear search on the array
	public int search(final int value) {
		for (int i = 0; i <= this.lastUsedIndex; i++) {
			if (this.arr[i] == value) {
				System.out.print(value + " exists in the Tree! ");
				System.out.println("It is at the location: " + i);
				return i;
			}
		}
		System.out.println(value + " does not exists in Tree !");
		System.out.println();
		return -1;
	}

	// delete operation of binary tree
	public void delete(final int value) {
		final int location = this.search(value);
		// If Value does not exists in Array
		if (location == -1) {
			return;
		} else {
			// insert last element of the Tree into current location
			this.arr[location] = this.arr[this.lastUsedIndex];
			this.lastUsedIndex--;
			System.out.println("Successfully deleted " + value + " from the Tree !");
		}
	}

	public void deleteTree() {
		try {
			this.arr = null;
			System.out.println("Tree has been deleted successfully !");
		} catch (final Exception e) {
			System.out.println("There was an error deleting the tree.");
		}
	}
}
