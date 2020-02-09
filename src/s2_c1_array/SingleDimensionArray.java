package s2_c1_array;

public class SingleDimensionArray {

    int[] arr = null;

    //constructor
    public SingleDimensionArray(final int size) {
        this.arr = new int[size];
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = Integer.MIN_VALUE;
        }
    }

    //traverse array
    public void traverseArray() {
        try {
            for (int i = 0; i < this.arr.length; i++) {
                System.out.print(this.arr[i] + " ");
            }
        } catch (final Exception e) {
            System.out.println("Array no longer exists.");
        }
    }

    //insert in array
    public void insert(final int location, final int valueToBeInserted) {
        try {
            if (this.arr[location] == Integer.MIN_VALUE) {
                this.arr[location] = valueToBeInserted;
                System.out.println("Successfully Inserted " + valueToBeInserted + " at location " + location);
            } else {
                System.out.println("This cell is already occupied by other value.");
            }
        } catch (final Exception e) {
            System.out.println("Invalid index to access array.");
        }
    }

    //accessing a cell
    public void accessingACell(final int cellNo) {
        try {
            System.out.println(this.arr[cellNo]);
        } catch (final Exception e) {
            System.out.println("Invalid index to access array.");
        }
    }

    //search a value
    public void searchInAnArray(final int valueToSearch) {
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == valueToSearch) {
                System.out.println("Value found.");
                System.out.println("Index of value " + valueToSearch + " is " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " not found.");
    }

    //deleting a value
    public void delete(final int cellNo) {
        try {
            this.arr[cellNo] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted value at cell " + cellNo);
        } catch (final Exception e) {
            System.out.println("Error, this cell is not exist");
        }
    }

}
