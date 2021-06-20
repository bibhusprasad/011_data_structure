package s3_c4_hashing;

public class DoubleHashingMain {

	public static void main(final String[] args) {

		// Constructor
		final DoubleHashing doubleHashing = new DoubleHashing();

		doubleHashing.insertKeyInHashTable("The");
		doubleHashing.insertKeyInHashTable("quick");
		doubleHashing.insertKeyInHashTable("brown");
		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.insertKeyInHashTable("over");
		doubleHashing.insertKeyInHashTable("lazy");
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox"); // use for showing collision
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.displayHashTable();

		doubleHashing.searchKeyInHashTable("jump");
		doubleHashing.searchKeyInHashTable("brown");

		doubleHashing.deleteKeyFromHashTable("jump");
		doubleHashing.deleteKeyFromHashTable("quick");
		doubleHashing.displayHashTable();

		doubleHashing.deleteHashTable();
		doubleHashing.displayHashTable();
	}
}
