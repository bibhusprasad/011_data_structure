package s2_c2_linkedlist;

import s2_c2_node.SingleNode;

public class SingleLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size; // denotes size of list

	public SingleNode createSingleLinkedList(final int nodeValue) {
		this.head = new SingleNode();
		final SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		this.head = node;
		this.tail = node;
		this.size = 1;
		return this.head;
	}

	public boolean existsLinkedList() {
		// if head is not null return true otherwise return false
		return this.head != null;
	}

	public void traverseLinkedList() {
		if (this.existsLinkedList()) {
			SingleNode tempNode = this.head;
			for (int i = 0; i < this.getSize(); i++) {
				System.out.print(tempNode.getValue());
				if (i != this.getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}

	public void insertInLinkedList(final int nodeValue, final int location) {
		final SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if (!this.existsLinkedList()) { // Linked List does not exists
			System.out.println("The linked list not exist.");
			return;
		}
		if (location == 0) { // insert at first position
			node.setNext(this.head);
			this.head = node;
		} else if (location >= this.size) { // insert at last position
			node.setNext(null);
			this.tail.setNext(node);
			this.tail = node;
		} else { // insert at specified location
			SingleNode tempNode = this.head;
			int index = 0;
			while (index < location - 1) { // loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			} // tempNode currently references to node after which we should insert new node
			final SingleNode nextNode = tempNode.getNext(); // this is the immediate next node after new node
			tempNode.setNext(node); // update reference of tempNode to reference to new node
			node.setNext(nextNode); // update newly added nodes' next.
		}
		this.setSize(this.getSize() + 1);
	}

	public void searchNode(final int searchValue) {
		SingleNode tempNode = this.head;
		for (int i = 0; i < this.size - 1; i++) {
			if (tempNode.getValue() == searchValue) {
				System.out.println("The value is present at location : " + i);
				return;
			}
			tempNode = this.head.getNext();
		}
		System.out.println("The value is not present");
	}

	public void deletionOfNode(final int location) {
		if (!this.existsLinkedList()) { // Linked List does not exists
			System.out.println("List not present");
			return;
		}
		if (location == 0) { // we want to delete first element
			this.head = this.head.getNext();
			this.setSize(this.getSize() - 1);
			if (this.getSize() == 0) { // if there are no more nodes in this list
				this.tail = null;
			}
		} else if (location >= this.size - 1) { // If location is not in range or equal, then delete last node
			SingleNode tempNode = this.head;
			for (int i = 0; i < this.size - 1; i++) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == this.head) { // if this is the only element in the list
				this.tail = this.head = null;
				this.setSize(this.getSize() - 1);
				return;
			}
			tempNode.setNext(null);
			this.tail = tempNode;
			this.setSize(this.getSize() - 1);
		} else { // if any inside node is to be deleted
			SingleNode tempNode = this.head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			this.setSize(this.getSize() - 1);
		}
	}

	public void deleteLinkedList() {
		this.head = null;
		this.tail = null;
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
