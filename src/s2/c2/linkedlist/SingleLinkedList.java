package s2.c2.linkedlist;

import s2.c2.node.SingleNode;

public class SingleLinkedList {

    private SingleNode head;
    private SingleNode tail;
    private int size;   //denotes size of list

    public SingleNode createSingleLinkedList(int nodeValue){
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public boolean existsLinkedList() {
        // if head is not null return true otherwise return false
        return head != null;
    }

    public void traverseLinkedList(){
        if(existsLinkedList()){
            SingleNode tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if(i != getSize() - 1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
        }else{
            System.out.println("Linked List does not exists !");
        }
        System.out.println("\n");
    }

    public void insertInLinkedList(int nodeValue, int location){
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if(!existsLinkedList()){    // Linked List does not exists
            System.out.println("The linked list not exist.");
            return;
        }
        if(location == 0){ // insert at first position
            node.setNext(head);
            head = node;
        } else if(location >= size){ // insert at last position
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        } else { // insert at specified location
            SingleNode tempNode = head;
            int index = 0;
            while(index < location - 1){ // loop till we reach specified node
                tempNode = tempNode.getNext();
                index++;
            } //tempNode currently references to node after which we should insert new node
            SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node
            tempNode.setNext(node); //update reference of tempNode to reference to new node
            node.setNext(nextNode); //update newly added nodes' next.
        }
        setSize(getSize() + 1);
    }

    public void searchNode(int searchValue){
        SingleNode tempNode = head;
        for (int i = 0; i < size -1; i++) {
            if(tempNode.getValue() == searchValue){
                System.out.println("The value is present at location : "+ i);
                return;
            }
            tempNode = head.getNext();
        }
        System.out.println("The value is not present");
    }

    public void deletionOfNode(int location) {
        if(!existsLinkedList()){    // Linked List does not exists
            System.out.println("List not present");
            return;
        }
        if(location == 0){  // we want to delete first element
            head = head.getNext();
            setSize(getSize() - 1);
            if(getSize() == 0){ // if there are no more nodes in this list
                tail = null;
            }
        } else if (location >= size-1){ //If location is not in range or equal, then delete last node
            SingleNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNext();
            }
            if(tempNode == head){ //if this is the only element in the list
                tail = head = null;
                setSize(getSize()-1);
                return;
            }
            tempNode.setNext(null);
            tail = tempNode;
            setSize(getSize() -1);
        } else {    //if any inside node is to be deleted
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();  // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize() -1);
        }
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
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
