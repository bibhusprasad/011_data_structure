package s2_c1_array;

public class TwoDimensionArrayMain {

    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(2,3);
        System.out.println("Printing the array elements.");
        twoDimensionArray.traverseArray();
        System.out.println();
        System.out.println("Inserting array elements.");
        twoDimensionArray.insert(0, 0, 10);
        twoDimensionArray.insert(0, 1, 20);
        twoDimensionArray.insert(0, 2, 30);
        twoDimensionArray.insert(1, 0, 40);
        twoDimensionArray.insert(1, 1, 50);
        twoDimensionArray.insert(1, 2, 60);
        System.out.println();
        twoDimensionArray.accessingACell(1, 0);
        System.out.println();
        twoDimensionArray.searchInAnArray(50);
        System.out.println();
        System.out.println("Delete a cell");
        twoDimensionArray.delete(1,2);
        System.out.println();
        System.out.println("Final Array Content");
        twoDimensionArray.traverseArray();
    }
}
