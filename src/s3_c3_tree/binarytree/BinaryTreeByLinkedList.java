package s3_c3_tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import s3_c3_node.BinaryNode;

public class BinaryTreeByLinkedList {

	BinaryNode root;

	// Constructor for creating a blank Binary Tree
	public BinaryTreeByLinkedList() {
		this.root = null;
	}

	// Inserts a new node at deepest place in Tree
	public void insert(final int value) {
		final BinaryNode node = new BinaryNode();
		node.setValue(value);
		if (null == this.root) {
			this.root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		} // end of if
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			final BinaryNode presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		} // end of while
	}

	// pre-order traversal of binary tree
	public void preOrder(final BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		this.preOrder(node.getLeft());
		this.preOrder(node.getRight());
	}

	// in-order traversal of binary tree
	public void inOrder(final BinaryNode node) {
		if (node == null) {
			return;
		}
		this.inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		this.inOrder(node.getRight());
	}

	// post-order traversal of binary tree
	public void postOrder(final BinaryNode node) {
		if (node == null) {
			return;
		}
		this.postOrder(node.getLeft());
		this.postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	// level-order traversal of binary tree
	public void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
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

	// Search for a given value in binary tree
	public void search(final int value) {
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			final BinaryNode presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value-" + value + " is found in Tree !");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		} // end of while loop
		System.out.println("Value-" + value + " is not found in Tree !");
	}

	// delete node from binary tree
	public void deleteNodeOfBinaryTree(final int value) {
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			final BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(this.getDeepestNode().getValue());
				this.deleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		} // end of while loop
		System.out.println("Did not find the node!!");
	}

	// get last node of last level of binary tree
	private BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}

	// Delete deepest node
	private void deleteDeepestNode() {
		final Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(this.root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			} else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		} // end of while loop
	}

	// Delete Tree
	public void deleteTree() {
		this.root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}
}
