package s2_c2_linkedlist;

import s2_c2_node.SingleNode;

public class CircularSingleLinkedList {

    SingleNode head;
    SingleNode tail;
    int size;   //denotes size of list

    public void createSingleLinkedList(int nodeValue) {
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(node);
        head = node;
        tail = node;
        size = 1;
    }

    public boolean existsLinkedList() {
        // if head is not null return true otherwise return false
        return head != null;
    }

    public void traverseLinkedList() {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
        } else {
            System.out.println("Linked list not exist.");
        }
        System.out.println("\n");
    }

    public void insertInLinkedList(int nodeValue, int location) {
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        System.out.println("Inserting new node at location: " + location);
        if (!existsLinkedList()) {
            System.out.println("Linked list not present");
            return; // Linked List does not exists
        } else if (location == 0) {    // insert at first position
            node.setNext(head);
            head = node;
            tail.setNext(node);     // update tail
        } else if (location >= getSize()) {    // insert at last position
            tail.setNext(node);
            tail = node; // to keep track of last node
            tail.setNext(head); // update tail to circularly point head
        } else {    // insert at specified location
            SingleNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
        }
        setSize(getSize() + 1);
    }

    // Traverse Linked List
    void printHeadUsingTail() {
        if (existsLinkedList()) {
            System.out.println("Printing Tail...");
            System.out.println(tail.getValue());

            System.out.println("Printing Head using Head reference...");
            System.out.println(head.getValue());

            System.out.println("Printing Head using Tail reference...");
            System.out.println(tail.getNext().getValue());

        } else {
            System.out.println("Linked List does not exists");
        }
    }

    public void searchNode(int nodeValue) {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
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

    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("Linked List does not exists");
            return;
        }
        if (location == 0) {  // we want to delete first element
            head = head.getNext();
            tail.setNext(head);
            setSize(getSize() - 1);
            if (getSize() == 0) { //if there are no more nodes in this list
                tail = null;
                head = null;
            }
        } else if (location >= getSize() - 1) { //If location is not in range or equal, then delete last node
            SingleNode tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.getNext();
            }
            if (tempNode == head) { //if this is the only element in the list
                tail = head = null;
                setSize(getSize() - 1);
                return;
            }
            tempNode.setNext(head);
            tail = tempNode;
            setSize(getSize() - 1);
        } else { //if any inside node is to be deleted
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize() - 1);
        }//end of else
    }

    //Delete linked list
    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        if (tail == null) {
            System.out.println("Linked List is already deleted, nothing to delete !");
            return;
        } else {
            tail.setNext(null);
            tail = null;
            System.out.println("Linked List deleted successfully !");
        }
    }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
