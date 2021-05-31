package s2_c1_array;

public class TwoDimensionArray {

	int[][] arr = null;

	// constructor
	public TwoDimensionArray(final int row, final int column) {
		this.arr = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				this.arr[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	// traverse array
	public void traverseArray() {
		try {
			for (int i = 0; i < this.arr.length; i++) {
				for (int j = 0; j < this.arr[0].length; j++) {
					System.out.print(this.arr[i][j] + " ");
				}
				System.out.println();
			}
		} catch (final Exception e) {
			System.out.println("Array no longer exists.");
		}
	}

	// insert in array
	public void insert(final int row, final int column, final int valueToBeInserted) {
		try {
			if (this.arr[row][column] == Integer.MIN_VALUE) {
				this.arr[row][column] = valueToBeInserted;
				System.out.println("Successfully Inserted " + valueToBeInserted + " at location " + row + " " + column);
			} else {
				System.out.println("This cell is already occupied by other value.");
			}
		} catch (final Exception e) {
			System.out.println("Invalid index to access array.");
		}
	}

	// accessing a cell
	public void accessingACell(final int row, final int column) {
		try {
			System.out.println(this.arr[row][column]);
		} catch (final Exception e) {
			System.out.println("Invalid index to access array.");
		}
	}

	// search a value
	public void searchInAnArray(final int valueToSearch) {
		for (int i = 0; i < this.arr.length; i++) {
			for (int j = 0; j < this.arr[0].length; j++) {
				if (this.arr[i][j] == valueToSearch) {
					System.out.println("Value found.");
					System.out.println("Index of value " + valueToSearch + " is " + i + " " + j);
					return;
				}
			}
		}
		System.out.println(valueToSearch + " not found.");
	}

	// deleting a value
	public void delete(final int row, final int column) {
		try {
			this.arr[row][column] = Integer.MIN_VALUE;
			System.out.println("Successfully deleted value at cell " + row + " " + column);
		} catch (final Exception e) {
			System.out.println("Error, this cell is not exist");
		}
	}

}
