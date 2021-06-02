package s2_c2_linkedlist;

import s2_c2_node.DoubleNode;

public class CircularDoubleLinkedList {

	private DoubleNode head;
	private DoubleNode tail;
	private int size;// denotes size of list

	public int getSize() {
		return this.size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

	DoubleNode createDoubleLinkedList(final int nodeValue) {
		this.head = new DoubleNode();
		final DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		node.setPrev(node);
		this.head = node;
		this.tail = node;
		this.size = 1;// size =1
		return this.head;
	}

	public DoubleNode getHead() {
		return this.head;
	}

	public void setHead(final DoubleNode head) {
		this.head = head;
	}

	public DoubleNode getTail() {
		return this.tail;
	}

	public void setTail(final DoubleNode tail) {
		this.tail = tail;
	}

	public int getLast() {
		return this.size;
	}

	public void setLast(final int last) {
		this.size = last;
	}

	void insertInLinkedList(final int nodeValue, final int location) {
		final DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!this.existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {// insert at first position
			node.setNext(this.head);
			node.setPrev(this.tail);
			this.head.setPrev(node);
			this.tail.setNext(node);
			this.head = node;
		} else if (location >= this.size) { // insert at last position
			node.setNext(this.head);
			node.setPrev(this.tail);
			this.head.setPrev(node);
			this.tail.setNext(node);
			this.tail = node; // to keep track of last node
		} else {// insert at specified location
			DoubleNode tempNode = this.head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		this.size++;// one node added so size increments
	}

	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return this.head != null;
	}

	// Traverse Linked List
	void traverseLinkedList() {
		if (this.existsLinkedList()) {
			DoubleNode tempNode = this.head;
			for (int i = 0; i < this.size; i++) {

				System.out.print(tempNode.getValue());
				if (i != this.size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();
	}

	// Traverse Linked List reverse order
	void traverseLinkedListInReverseOrder() {
		if (this.existsLinkedList()) {
			DoubleNode tempNode = this.tail;
			System.out.println("\nPrinting Linked list in reverse order...");
			for (int i = 0; i < this.size; i++) {
				System.out.print(tempNode.getValue());
				if (i != this.size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
	}

	// Traverse Linked List
	void printHeadUsingTail() {
		if (this.existsLinkedList()) {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(this.tail.getValue());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(this.head.getValue());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(this.tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	// Deletion of linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		if (this.tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		} else {
			this.head.setPrev(null);
			this.tail.setNext(null);
			this.head = null;
			this.tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}// end of method

	// Searching a specified value in linked list
	boolean searchNode(final int nodeValue) {
		if (this.existsLinkedList()) {
			DoubleNode tempNode = this.head;
			this.traverseLinkedList();
			for (int i = 0; i < this.size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");
		return false;
	}

	// Deletes a node having a given value
	public void deletionOfNode(final int location) {
		if (!this.existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			if (this.getSize() == 1) { // if this is the only node in this list
				this.head.setNext(null);
				this.head.setPrev(null);
				this.head = this.tail = null;
				this.setSize(this.getSize() - 1);
				return;
			} else {
				this.head = this.head.getNext();
				this.head.setPrev(null);
				this.tail.setNext(this.head);
				this.setSize(this.getSize() - 1);
			}
		} else if (location >= this.getSize()) { // If location is not in range or equal, then delete last node
			if (this.getSize() == 1) { // if this is the only element in the list
				this.head.setNext(null);
				this.head.setPrev(null);
				this.tail = this.head = null;
				this.setSize(this.getSize() - 1);
				return;
			}
			this.tail = this.tail.getPrev();
			this.tail.setNext(this.head);
			this.head.setPrev(this.tail);
			this.setSize(this.getSize() - 1);
		} else { // if any inside node is to be deleted
			DoubleNode tempNode = this.head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrev(tempNode);
			this.setSize(this.getSize() - 1);
		} // end of else

	}// end of method

}
