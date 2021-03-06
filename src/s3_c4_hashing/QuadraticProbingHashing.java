package s3_c4_hashing;

import java.util.ArrayList;

public class QuadraticProbingHashing {

	String[] hashTable;
	int noOfCellsUsedInHashTable;

	// Constructor
	public QuadraticProbingHashing() {
		this.hashTable = new String[13];
		this.noOfCellsUsedInHashTable = 0;
	}

	// Insert key in HashTable
	public void insertKeyInHashTable(final String value) {
		final double loadFactor = this.getLoadFactor();
		if (loadFactor >= 0.75) { // we need to rehash in new table doubling the size
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
			this.rehashKeys(value);
		} else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			final int index = this.simpleASCIIHashFunction(value, this.hashTable.length);
			int counter = 0;
			for (int i = index; i < index + this.hashTable.length; i++) {
				final int newIndex = (index + (counter * counter)) % this.hashTable.length;
				if (this.hashTable[newIndex] == null) { // If index is blank, then insert there
					this.hashTable[newIndex] = value;
					System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				} else {
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
				counter++;
			} // end of for loop
		} // end of if-else block
		this.noOfCellsUsedInHashTable++;
	}

	// Returns LoadFactor of HashTable
	private double getLoadFactor() {
		return this.noOfCellsUsedInHashTable * 1.0 / this.hashTable.length;
	}

	// Creates a new HashTable and does ReHashing
	private void rehashKeys(final String newStringToBeInserted) {
		this.noOfCellsUsedInHashTable = 0; // need to reset it as we are now dealing with fresh HashTable
		final ArrayList<String> data = new ArrayList<>();
		for (final String s : this.hashTable) { // loop through the HashTable and save all the keys in ArrayList
			if (s != null) {
				data.add(s);
			}
		}
		data.add(newStringToBeInserted);
		this.hashTable = new String[this.hashTable.length * 2]; // make new table with double size
		for (final String s : data) { // push all old data into new table
			this.insertKeyInHashTable(s);
		}
	}

	// HashFunction to be used on Keys
	public int simpleASCIIHashFunction(final String x, final int M) {
		final char[] ch;
		ch = x.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < x.length(); i++) {
			sum += ch[i];
		}
		// System.out.println("Index from hashfunction: " + sum % M);
		return sum % M;
	}

	// Display the hash table
	public void displayHashTable() {
		if (this.hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < this.hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + this.hashTable[i]);
			}
		}
		System.out.println("\n");
	}

	// Search for a given key in hashTable
	public boolean searchKeyInHashTable(final String stringToBeSearched) {
		final int index = this.simpleASCIIHashFunction(stringToBeSearched, this.hashTable.length);
		for (int i = index; i < index + this.hashTable.length; i++) {
			final int newIndex = i % this.hashTable.length;
			if (this.hashTable[newIndex] != null && this.hashTable[newIndex].equals(stringToBeSearched)) {
				System.out.println(
						"\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
		return false;
	}

	// Delete key from HashTable
	public void deleteKeyFromHashTable(final String stringToBeDeleted) {
		final int index = this.simpleASCIIHashFunction(stringToBeDeleted, this.hashTable.length);
		for (int i = index; i < index + this.hashTable.length; i++) {
			final int newIndex = i % this.hashTable.length;
			if (this.hashTable[newIndex] != null && this.hashTable[newIndex].equals(stringToBeDeleted)) {
				this.hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable.");
				System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !");
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
	}

	// deletes entire HashTable
	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
        this.hashTable = null;
	}
}
