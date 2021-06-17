package s3_c3_tree.avltree;

import java.util.LinkedList;
import java.util.Queue;

import s3_c3_node.BinaryNode;

public class AvlTreeByLinkedList {

	BinaryNode root;

	public BinaryNode getRoot() {
		return this.root;
	}

	// Constructor
	public AvlTreeByLinkedList() {
		this.root = null;
	}

	// Insert values in AVL Tree
	public void insert(final int value) {
		this.root = this.insert(this.root, value);
	}

	private BinaryNode insert(BinaryNode currentNode, final int value) {
		// THIS ELSE_IF BLOCK IS BST CONDITION
		if (currentNode == null) {
			System.out.println("Successfully inserted " + value + " in AVL Tree");
			return this.createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(this.insert(currentNode.getLeft(), value));
		} else {
			currentNode.setRight(this.insert(currentNode.getRight(), value));
		}
		// THIS IS WHERE WE WILL DO AVL SPECIFIC WORK
		final int balance = this.checkBalance(currentNode.getLeft(), currentNode.getRight());
		if (balance > 1) {
			if (this.checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = this.rightRotate(currentNode);// LL Condition
			} else {
				currentNode.setLeft(this.leftRotate(currentNode.getLeft())); // LR Condition
				currentNode = this.rightRotate(currentNode);
			}
		} else if (balance < -1) {
			if (this.checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
				currentNode = this.leftRotate(currentNode);// RR Condition
			} else {
				currentNode.setRight(this.rightRotate(currentNode.getRight()));// RL Condition
				currentNode = this.leftRotate(currentNode);
			}
		}
		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(this.calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(this.calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(this.calculateHeight(currentNode));
		return currentNode;

	}

	// creates a new blank new node
	private BinaryNode createNewNode(final int value) {
		final BinaryNode node = new BinaryNode();
		node.setValue(value);
		node.setHeight(0);// Since this is a leaf node, its height is 0
		return node;
	}

	private int checkBalance(final BinaryNode rootLeft, final BinaryNode rootRight) {
		if ((rootLeft == null) && (rootRight == null)) { // if current node is a leaf node then no need to check balance
															// of its children
			return 0;
		} else if (rootLeft == null) {
			return -1 * (rootRight.getHeight() + 1); // if left node node is not there then simply return right node's
			// height + 1
			// we need to make it -1 because blank height is considered
			// having height as '-1'
		} else if (rootRight == null) {
			return rootLeft.getHeight() + 1;
		} else {
			return rootLeft.getHeight() - rootRight.getHeight(); // +1 is not required, as both right and left child
			// exits and 1 gets nullified
		}
	}

	private BinaryNode leftRotate(final BinaryNode currentNode) {
		final BinaryNode newRoot = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeight(this.calculateHeight(currentNode));
		newRoot.setHeight(this.calculateHeight(newRoot));
		return newRoot;
	}

	private BinaryNode rightRotate(final BinaryNode currentNode) {
		final BinaryNode newRoot = currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeight(this.calculateHeight(currentNode));
		newRoot.setHeight(this.calculateHeight(newRoot));
		return newRoot;
	}

	// Calculate height of Node
	private int calculateHeight(final BinaryNode currentNode) {
		if (currentNode == null) {
			return 0;
		}
		return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : -1),
				(currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));
	}

	// Level order traversal of BST
	public void levelOrderTraversal() {
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		System.out.println("Printing Level order traversal of AVL Tree...");
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

	public void printTreeGraphically() {
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
				if (previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}
	}

	public void deleteNodeOfBST(final int value) {
		System.out.println("Deleting " + value + " from AVL Tree ...");
		this.root = this.deleteNodeOfBST(this.root, value);
	}

	private BinaryNode deleteNodeOfBST(BinaryNode currentNode, final int value) {
		// THIS ELSE_IF BLOCK IS BST CONDITION
		if (currentNode == null) {
			return null;
		}
		if (value < currentNode.getValue()) {
			currentNode.setLeft(this.deleteNodeOfBST(currentNode.getLeft(), value));
		} else if (value > currentNode.getValue()) {
			currentNode.setRight(this.deleteNodeOfBST(currentNode.getRight(), value));
		} else { // If currentNode is the node to be deleted
			// System.out.println("currentNode is the node to be deleted");
			if (currentNode.getLeft() != null && currentNode.getRight() != null) { // if nodeToBeDeleted have both
																					// children
				final BinaryNode temp = currentNode;
				final BinaryNode minNodeForRight = this.minimumElement(temp.getRight());// Finding minimum element from
																						// right
				// subtree
				currentNode.setValue(minNodeForRight.getValue()); // Replacing current node with minimum node from right
																	// subtree
				this.deleteNodeOfBST(currentNode.getRight(), minNodeForRight.getValue());// Deleting minimum node from
																							// right
				// now
			} else if (currentNode.getLeft() != null) {// if nodeToBeDeleted has only left child
				currentNode = currentNode.getLeft();
			} else if (currentNode.getRight() != null) {// if nodeToBeDeleted has only right child
				currentNode = currentNode.getRight();
			} else { // if nodeToBeDeleted do not have child (Leaf node)
				// System.out.println("This node is leaf node");
				currentNode = null;
			}
			return currentNode;// if it is a leaf node,then no need to do balancing for this node, do only for
								// its ancestors
		}

		// THIS IS WHERE WE WILL DO AVL SPECIFIC WORK
		final int balance = this.checkBalance(currentNode.getLeft(), currentNode.getRight());
		if (balance > 1) {
			if (this.checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = this.rightRotate(currentNode);// LL Condition
			} else {
				currentNode.setLeft(this.leftRotate(currentNode.getLeft())); // LR Condition
				currentNode = this.rightRotate(currentNode);
			}
		} else if (balance < -1) {
			if (this.checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
				currentNode = this.leftRotate(currentNode);// RR Condition
			} else {
				currentNode.setRight(this.rightRotate(currentNode.getRight()));// RL Condition
				currentNode = this.leftRotate(currentNode);
			}
		}

		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(this.calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(this.calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(this.calculateHeight(currentNode));
		return currentNode;
	}

	private BinaryNode minimumElement(final BinaryNode root) {
		if (root.getLeft() == null) {
			return root;
		} else {
			return this.minimumElement(root.getLeft());
		}
	}

	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		this.root = null;
		System.out.println("Tree deleted successfully !");
	}

}
