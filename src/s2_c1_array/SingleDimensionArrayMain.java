package s2_c1_array;

public class SingleDimensionArrayMain {

	public static void main(final String[] args) {
		final SingleDimensionArray singleDimensionArray = new SingleDimensionArray(10);
		System.out.println("Printing the array elements.");
		singleDimensionArray.traverseArray();
		System.out.println();
		System.out.println();
		System.out.println("Inserting array elements.");
		singleDimensionArray.insert(0, 0);
		singleDimensionArray.insert(1, 10);
		singleDimensionArray.insert(2, 20);
		singleDimensionArray.insert(3, 30);
		singleDimensionArray.insert(4, 40);
		singleDimensionArray.insert(5, 50);
		singleDimensionArray.insert(6, 60);
		singleDimensionArray.insert(7, 70);
		singleDimensionArray.insert(8, 80);
		singleDimensionArray.insert(9, 90);
		singleDimensionArray.insert(9, 100);
		singleDimensionArray.insert(10, 110);
		System.out.println();
		singleDimensionArray.accessingACell(5);
		System.out.println();
		singleDimensionArray.searchInAnArray(70);
		System.out.println();
		System.out.println("Delete a cell");
		singleDimensionArray.delete(2);
		System.out.println();
		System.out.println("Final Array Content");
		singleDimensionArray.traverseArray();
	}
}
