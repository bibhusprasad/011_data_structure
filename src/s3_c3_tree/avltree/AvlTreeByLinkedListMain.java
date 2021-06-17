package s3_c3_tree.avltree;

public class AvlTreeByLinkedListMain {

	public static void main(final String[] args) {

		// Constructor
		final AvlTreeByLinkedList tree = new AvlTreeByLinkedList();

		// Insert values in AVL Tree
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(50);
		tree.insert(65);
		tree.insert(1);

		tree.levelOrderTraversal();
		tree.printTreeGraphically();

		tree.deleteNodeOfBST(5);// LL Condition
		tree.printTreeGraphically();

		tree.insert(2);
		tree.printTreeGraphically();

		tree.deleteNodeOfBST(4);// LR Condition
		tree.printTreeGraphically();

		tree.insert(20);
		tree.deleteNodeOfBST(65);// RR Condition
		tree.printTreeGraphically();

		tree.insert(40);
		tree.deleteNodeOfBST(20);// RL Condition
		tree.printTreeGraphically();

		tree.deleteTree();

	}
}
