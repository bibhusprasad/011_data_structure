package s2_c2_linkedlist;

public class DoubleLinkedListMain {

    public static void main(final String[] args) {
        final DoubleLinkedList list = new DoubleLinkedList();
        list.createDoubleLinkedList(5);
        list.traverseLinkedList();

        list.insertInLinkedList(10, 0);
        list.insertInLinkedList(20, 3);
        list.insertInLinkedList(30, 2);
        list.insertInLinkedList(40, 1);
        list.traverseLinkedList();

        System.out.println("\nSearching the node having value 40: ");
        list.searchNode(40);
        System.out.println("\n\nSearching the node having value 400: ");
        list.searchNode(400);

        System.out.println("\n\nLinked List in order");
        list.traverseLinkedList();
        System.out.println("Linked List in reverse order");
        list.traverseLinkedListInReverseOrder();


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("List after deletion: ");
        list.traverseLinkedList();

        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("List after deletion: ");
        list.traverseLinkedList();

        list.deleteLinkedList();
        list.traverseLinkedList();

        list.findHeadAndTail();
    }
}
