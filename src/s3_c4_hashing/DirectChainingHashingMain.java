package s3_c4_hashing;

public class DirectChainingHashingMain {

	public static void main(final String[] args) {

		final DirectChainingHashing directChaining = new DirectChainingHashing();

		directChaining.insertKeyInHashTable("The");
		directChaining.insertKeyInHashTable("quick");
		directChaining.insertKeyInHashTable("brown");
		directChaining.insertKeyInHashTable("fox");
		directChaining.insertKeyInHashTable("over");
		directChaining.insertKeyInHashTable("lazy");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); // use for showing collision
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();
		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox");
		directChaining.displayHashTable();

		directChaining.searchKeyInHashTable("jump");
		directChaining.searchKeyInHashTable("brown");

		directChaining.deleteKeyFromHashTable("jump");
		directChaining.deleteKeyFromHashTable("quick");
		directChaining.displayHashTable();

		directChaining.deleteHashTable();
		directChaining.displayHashTable();

	}
}
