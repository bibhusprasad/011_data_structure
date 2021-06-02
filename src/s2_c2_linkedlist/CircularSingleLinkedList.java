package s2_c2_linkedlist;

import s2_c2_node.SingleNode;

public class CircularSingleLinkedList {

	SingleNode head;
	SingleNode tail;
	int size; // denotes size of list

	public void createSingleLinkedList(final int nodeValue) {
		final SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	public boolean existsLinkedList() {
		// if head is not null return true otherwise return false
		return this.head != null;
	}

	public void traverseLinkedList() {
		if (this.existsLinkedList()) {
			SingleNode tempNode = this.head;
			for (int i = 0; i < this.size; i++) {
				System.out.print(tempNode.getValue());
				if (i != this.getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked list not exist.");
		}
		System.out.println("\n");
	}

	public void insertInLinkedList(final int nodeValue, final int location) {
		final SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		System.out.println("Inserting new node at location: " + location);
		if (!this.existsLinkedList()) {
			System.out.println("Linked list not present");
			return; // Linked List does not exists
		} else if (location == 0) { // insert at first position
			node.setNext(this.head);
			this.head = node;
			this.tail.setNext(node); // update tail
		} else if (location >= this.getSize()) { // insert at last position
			this.tail.setNext(node);
			this.tail = node; // to keep track of last node
			this.tail.setNext(this.head); // update tail to circularly point head
		} else { // insert at specified location
			SingleNode tempNode = this.head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.getNext();
				index++;
			}
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
		this.setSize(this.getSize() + 1);
	}

	// Traverse Linked List
	void printHeadUsingTail() {
		if (this.existsLinkedList()) {
			System.out.println("Printing Tail...");
			System.out.println(this.tail.getValue());

			System.out.println("Printing Head using Head reference...");
			System.out.println(this.head.getValue());

			System.out.println("Printing Head using Tail reference...");
			System.out.println(this.tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	public void searchNode(final int nodeValue) {
		if (this.existsLinkedList()) {
			SingleNode tempNode = this.head;
			for (int i = 0; i < this.size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.println("Value present at location : " + i);
					return;
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("The value is not present");
		} else {
			System.out.println("Linked List does not exists");
		}
	}

	public void deletionOfNode(final int location) {
		if (!this.existsLinkedList()) {
			System.out.println("Linked List does not exists");
			return;
		}
		if (location == 0) { // we want to delete first element
			this.head = this.head.getNext();
			this.tail.setNext(this.head);
			this.setSize(this.getSize() - 1);
			if (this.getSize() == 0) { // if there are no more nodes in this list
				this.tail = null;
				this.head = null;
			}
		} else if (location >= this.getSize() - 1) { // If location is not in range or equal, then delete last node
			SingleNode tempNode = this.head;
			for (int i = 0; i < this.size - 2; i++) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == this.head) { // if this is the only element in the list
				this.tail = this.head = null;
				this.setSize(this.getSize() - 1);
				return;
			}
			tempNode.setNext(this.head);
			this.tail = tempNode;
			this.setSize(this.getSize() - 1);
		} else { // if any inside node is to be deleted
			SingleNode tempNode = this.head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			this.setSize(this.getSize() - 1);
		} // end of else
	}

	// Delete linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		this.head = null;
		if (this.tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		} else {
			this.tail.setNext(null);
			this.tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}

	public SingleNode getHead() {
		return this.head;
	}

	public void setHead(final SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return this.tail;
	}

	public void setTail(final SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

}
