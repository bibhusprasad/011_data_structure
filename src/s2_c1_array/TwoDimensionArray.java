package s2_c1_array;

public class TwoDimensionArray {

    int[][] arr = null;

    //constructor
    public TwoDimensionArray(int row, int column) {
        arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    //traverse array
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists.");
        }
    }

    //insert in array
    public void insert(int row, int column, int valueToBeInserted) {
        try {
            if (arr[row][column] == Integer.MIN_VALUE) {
                arr[row][column] = valueToBeInserted;
                System.out.println("Successfully Inserted " + valueToBeInserted + " at location " + row + " " + column);
            } else {
                System.out.println("This cell is already occupied by other value.");
            }
        } catch (Exception e) {
            System.out.println("Invalid index to access array.");
        }
    }

    //accessing a cell
    public void accessingACell(int row, int column) {
        try {
            System.out.println(arr[row][column]);
        } catch (Exception e) {
            System.out.println("Invalid index to access array.");
        }
    }

    //search a value
    public void searchInAnArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    System.out.println("Value found.");
                    System.out.println("Index of value " + valueToSearch + " is " + i + " " + j);
                    return;
                }
            }
        }
        System.out.println(valueToSearch + " not found.");
    }

    //deleting a value
    public void delete(int row, int column) {
        try {
            arr[row][column] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted value at cell " + row + " " + column);
        } catch (Exception e) {
            System.out.println("Error, this cell is not exist");
        }
    }

}
