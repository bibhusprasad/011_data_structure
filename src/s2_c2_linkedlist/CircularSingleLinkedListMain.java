package s2_c2_linkedlist;

public class CircularSingleLinkedListMain {

    public static void main(String[] args){
        CircularSingleLinkedList list = new CircularSingleLinkedList();
        list.createSingleLinkedList(5);
        System.out.println("Linked List now: ");
        list.traverseLinkedList();

        list.insertInLinkedList(10, 0);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 2);
        list.insertInLinkedList(40, 1);
        list.insertInLinkedList(35, 4);
        list.insertInLinkedList(1, 0);
        list.insertInLinkedList(100, 10);
        System.out.println("Linked List now: ");
        list.traverseLinkedList();

        list.printHeadUsingTail();

        System.out.println("Searching the node having value 40: ");
        list.searchNode(40);
        System.out.println("Searching the node having value 200: ");
        list.searchNode(200);
        System.out.println("Searching the node having value 20: ");
        list.searchNode(20);

        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(0);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 15: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(15);
        System.out.println("After deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 15: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(15);
        System.out.println("After deletion...");
        list.traverseLinkedList();

        list.deleteLinkedList();
        list.traverseLinkedList();

    }
}
