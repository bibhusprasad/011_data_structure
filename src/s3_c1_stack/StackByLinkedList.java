package s3_c1_stack;

import s2_c2_linkedlist.SingleLinkedList;
import s2_c2_node.SingleNode;

public class StackByLinkedList {

    SingleLinkedList list;

    public StackByLinkedList(){
        list = new SingleLinkedList();
    }

    //push
    public void push(int value) {
        if(list.getHead() == null){
            list.createSingleLinkedList(value);
        }else{
            list.insertInLinkedList(value, 0);
        }
        System.out.println("Inserted " + value + " in Stack !");
    }

    //peek
    public int peek() {
        if(isEmpty()){
            System.out.println("The stack is empty!!");
            return -1;
        }else{
            return list.getHead().getValue();
        }
    }

    //isEmpty
    public boolean isEmpty() {
        if (list.getHead() == null)
            return true;
        else
            return false;
    }

    //pop
    public int pop() {
            int value = -1;
            if (isEmpty()) {
                System.out.println("Stack underflow error!!");
            } else {
                value = list.getHead().getValue();
                list.deletionOfNode(0);
            }
            return value;
    }

    //delete stack
    public void deleteStack() {
        list.setHead(null);
    }
}
