package s3_c1_stack;

import s2_c2_linkedlist.SingleLinkedList;

public class StackByLinkedList {

	SingleLinkedList list;

	public StackByLinkedList() {
		this.list = new SingleLinkedList();
	}

	// push
	public void push(final int value) {
		if (this.list.getHead() == null) {
			this.list.createSingleLinkedList(value);
		} else {
			this.list.insertInLinkedList(value, 0);
		}
		System.out.println("Inserted " + value + " in Stack !");
	}

	// peek
	public int peek() {
		if (this.isEmpty()) {
			System.out.println("The stack is empty!!");
			return -1;
		} else {
			return this.list.getHead().getValue();
		}
	}

	// isEmpty
	public boolean isEmpty() {
		if (this.list.getHead() == null) {
			return true;
		} else {
			return false;
		}
	}

	// pop
	public int pop() {
		int value = -1;
		if (this.isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = this.list.getHead().getValue();
			this.list.deletionOfNode(0);
		}
		return value;
	}

	// delete stack
	public void deleteStack() {
		this.list.setHead(null);
	}
}
