package s3_c4_hashing;

public class QuadraticProbingHashingMain {

	public static void main(final String[] args) {

		// Constructor
		final QuadraticProbingHashing quadraticProbing = new QuadraticProbingHashing();

		quadraticProbing.insertKeyInHashTable("The");
		quadraticProbing.insertKeyInHashTable("quick");
		quadraticProbing.insertKeyInHashTable("brown");
		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.insertKeyInHashTable("over");
		quadraticProbing.insertKeyInHashTable("lazy");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox"); // use for showing collision
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.displayHashTable();

		quadraticProbing.searchKeyInHashTable("jump");
		quadraticProbing.searchKeyInHashTable("brown");

		quadraticProbing.deleteKeyFromHashTable("jump");
		quadraticProbing.displayHashTable();

		quadraticProbing.deleteKeyFromHashTable("quick");
		quadraticProbing.displayHashTable();

		quadraticProbing.deleteHashTable();
		quadraticProbing.displayHashTable();
	}
}
