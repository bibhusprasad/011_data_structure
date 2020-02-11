package s3_c2_queue;

import s2_c2_linkedlist.SingleLinkedList;

public class LinearQueueByLinkedList {

    SingleLinkedList list;

    public LinearQueueByLinkedList() {
        this.list = new SingleLinkedList();
    }

    public void enQueue(final int value) {
        if (this.list.getHead() == null) {
            this.list.createSingleLinkedList(value);
        } else {
            // push a value on last of queue, update list tail too
            this.list.insertInLinkedList(value, this.list.getSize());
        }
    }

    public int deQueue() {
        int value = -1;
        if (this.isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            value = this.list.getHead().getValue();
            this.list.deletionOfNode(0);
        }
        return value;
    }

    public boolean isQueueEmpty() {
        if (this.list.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        if (!this.isQueueEmpty()) {
            return this.list.getHead().getValue();
        } else {
            System.out.println("The queue is empty!!");
            return -1;
        }
    }

    public void deleteStack() {
        this.list.setHead(null);
    }


}
