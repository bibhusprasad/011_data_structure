package s3_c3_tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import s3_c3_node.BinaryNode;

public class BinarySearchTreeByLinkedList {

	BinaryNode root;

	// Constructor
	BinarySearchTreeByLinkedList() {
		this.root = null;
	}

	// Insert values in BST
	public void insert(final int value) {
		this.root = this.insert(this.root, value);
	}

	private BinaryNode insert(final BinaryNode currentNode, final int value) {
		if (currentNode == null) { // if root node is blank then insert new node there
			System.out.println("Successfully inserted " + value + " in BST");
			return this.createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(this.insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(this.insert(currentNode.getRight(), value));
			return currentNode;
		}
	}

	// creates a new blank new node
	private BinaryNode createNewNode(final int value) {
		final BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}

	void printTreeGraphically() {
		final Queue<BinaryNode> queue = new LinkedList<>();
		final Queue<Integer> level = new LinkedList<>();

		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(this.root);
		level.add(1);

		System.out.println("\nPrinting Level order traversal of Tree...");
		if (this.root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		while (!queue.isEmpty()) {
			if (CurrentLevel == level.peek()) { // if we are in the same level
				if (queue.peek() == null) {
					queue.add(null);
					level.add(CurrentLevel + 1);
				} else {
					queue.add(queue.peek().getLeft());
					level.add(CurrentLevel + 1);
					queue.add(queue.peek().getRight());
					level.add(CurrentLevel + 1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");
				level.remove();
			} else { // level has changed
				System.out.println("\n");
				CurrentLevel++;
				if (previousLevelWasAllNull) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		} // end of loop
	}

	// Search a node in BST
	public void searchForValue(final int value) {
		this.searchForValue(this.root, value);
	}

	private BinaryNode searchForValue(final BinaryNode node, final int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return this.searchForValue(node.getLeft(), value);
		} else {
			return this.searchForValue(node.getRight(), value);
		}
	}

	// Deleting a node from BST
	public void deleteNodeOfBST(final int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		this.deleteNodeOfBST(this.root, value);
	}

	private BinaryNode deleteNodeOfBST(BinaryNode root, final int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.getValue()) {
			root.setLeft(this.deleteNodeOfBST(root.getLeft(), value));
		} else if (value > root.getValue()) {
			root.setRight(this.deleteNodeOfBST(root.getRight(), value));
		} else { // If currentNode is the node to be deleted

			if (root.getLeft() != null && root.getRight() != null) { // if nodeToBeDeleted have both children
				final BinaryNode minNodeForRight = this.minimumElement(root.getRight());// Finding minimum element from
																						// right

				// subtree
				root.setValue(minNodeForRight.getValue()); // Replacing current node with minimum node from right
															// subtree
				root.setRight(this.deleteNodeOfBST(root.getRight(), minNodeForRight.getValue())); // Deleting minimum
																									// node
																									// from right now
			} else if (root.getLeft() != null) {// if nodeToBeDeleted has only left child
				root = root.getLeft();
			} else if (root.getRight() != null) {// if nodeToBeDeleted has only right child
				root = root.getRight();
			} else // if nodeToBeDeleted do not have child (Leaf node)
			{
				root = null;
			}
		}
		return root;
	}

	// Get minimum element in binary search tree
	private BinaryNode minimumElement(final BinaryNode root) {
		if (root.getLeft() == null) {
			return root;
		} else {
			return this.minimumElement(root.getLeft());
		}
	}

	// Level order traversal of BST
	void levelOrderTraversal() {
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		System.out.println("\nPrinting Level order traversal of Tree...");
		if (this.root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			final BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
	}

	// Delete entire BST
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		this.root = null;
		System.out.println("Tree deleted successfully !");
	}
}
