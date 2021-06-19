package s3_c3_tree.binaryheap;

public class BinaryHeapByArrayMain {

	public static void main(final String[] args) {

		System.out.println("Creating a blank Heap");
		final BinaryHeapByArray heap = new BinaryHeapByArray(10);

		heap.insertInHeap(100);
		heap.insertInHeap(90);
		heap.insertInHeap(80);
		heap.insertInHeap(70);
		heap.insertInHeap(60);
		heap.insertInHeap(50);
		heap.insertInHeap(40);
		heap.insertInHeap(30);
		heap.insertInHeap(20);

		heap.extractHeadOfHeap();

		heap.insertInHeap(110);
		heap.extractHeadOfHeap();
	}
}
