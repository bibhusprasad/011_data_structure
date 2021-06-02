package s2_c2_linkedlist;

import s2_c2_node.DoubleNode;

public class DoubleLinkedList {

	private DoubleNode head;
	private DoubleNode tail;
	private int size; // denotes size of list

	public void createDoubleLinkedList(final int nodeValue) {
		final DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		node.setPrev(null);
		this.head = node;
		this.tail = node;
		this.setSize(1);
	}

	public boolean existsLinkedList() {
		return this.head != null;
	}

	public void traverseLinkedList() {
		if (this.existsLinkedList()) {
			// System.out.println("Linked List now: ");
			DoubleNode tempNode = this.head;
			for (int i = 0; i < this.size; i++) {
				System.out.print(tempNode.getValue());
				if (i != this.size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}

	public void insertInLinkedList(final int nodeValue, final int location) {
		final DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!this.existsLinkedList()) {
			System.out.println("Linked List not exist");
			return;
		}
		if (location == 0) {
			node.setNext(this.head);
			node.setPrev(null);
			this.head.setPrev(node);
			this.head = node;
		} else if (location >= this.size) {
			node.setNext(null);
			node.setPrev(this.tail);
			this.tail.setNext(node);
			this.tail = node;
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
		this.setSize(this.getSize() + 1);
	}

	public boolean searchNode(final int nodeValue) {
		if (this.existsLinkedList()) {
			DoubleNode tempNode = this.head;
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

	public void traverseLinkedListInReverseOrder() {
		if (this.existsLinkedList()) {
			DoubleNode tempNode = this.tail;
			for (int i = 0; i < this.size; i++) {
				System.out.print(tempNode.getValue());
				if (i != this.size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}

	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		DoubleNode tempNode = this.head;
		for (int i = 0; i < this.size; i++) {
			tempNode.setPrev(null);
			tempNode = tempNode.getNext();
		}

		this.head = null;
		this.tail = null;
		System.out.println("Linked List deleted successfully !");
	}

	public void deletionOfNode(final int location) {
		if (!this.existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			if (this.getSize() == 1) { // if this is the only node in this list
				this.head = this.tail = null;
				this.setSize(this.getSize() - 1);
				return;
			} else {
				this.head = this.head.getNext();
				this.head.setPrev(null);
				this.setSize(this.getSize() - 1);
			}
		} else if (location >= this.getSize()) { // If location is not in range or equal, then delete last node
			final DoubleNode tempNode = this.tail.getPrev(); // temp node points to 2nd last node
			if (tempNode == this.head) { // if this is the only element in the list
				this.tail = this.head = null;
				this.setSize(this.getSize() - 1);
				return;
			}
			tempNode.setNext(null);
			this.tail = tempNode;
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

	public void findHeadAndTail() {
		if (this.existsLinkedList()) {
			System.out.println("Head : " + this.head.getValue());
			System.out.println("Tail : " + this.tail.getValue());
		} else {
			System.out.println("Linked List not exist");
		}
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

	public int getSize() {
		return this.size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

}
