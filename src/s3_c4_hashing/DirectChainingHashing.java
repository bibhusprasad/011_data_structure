package s3_c4_hashing;

import java.util.LinkedList;

public class DirectChainingHashing {

	LinkedList<String>[] hashTable;
	int maximumChainSize = 5;

	public DirectChainingHashing() {
		this.hashTable = new LinkedList[13];
	}

	// Insert Key in HashTable
	public void insertKeyInHashTable(final String value) {
		final int newIndex = this.simpleASCIIHashFunction(value, this.hashTable.length); // returns in which index we
																							// need to
		// store this
		// string
		if (this.hashTable[newIndex] == null) {
			System.out.println("Index: " + newIndex + " is empty. Creating a new LinkedList there...");
			this.hashTable[newIndex] = new LinkedList<>();
			this.hashTable[newIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
			System.out.println("-------------------------------------------\n");
		} else {
			System.out.println("\nIndex: " + newIndex + " is having sufficient space. Inserting there...");
			this.hashTable[newIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
			System.out.println("-------------------------------------------\n");
		}
	}

	// HashFunction to be used on Keys
	private int simpleASCIIHashFunction(final String x, final int M) {
		final char[] ch;
		ch = x.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < x.length(); i++) {
			sum = sum + ch[i];
		}
		// System.out.println("Index from hashfunction: " + sum % M);
		return sum % M;
	}

	// display the hash table
	public void displayHashTable() {
		if (this.hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < this.hashTable.length; i++) {
				System.out.println("Index: " + i + ", key: " + this.hashTable[i]);

			}
		}
	}

	// Search for a given key in hashTable
	public boolean searchKeyInHashTable(final String stringToBeSearched) {
		final int newIndex = this.simpleASCIIHashFunction(stringToBeSearched, this.hashTable.length);
		if (this.hashTable[newIndex] != null && this.hashTable[newIndex].contains(stringToBeSearched)) {
			System.out
					.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: " + newIndex);
			return true;
		} else {
			System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
			return false;
		}
	}

	// Delete key from HashTable
	public void deleteKeyFromHashTable(final String stringToBeDeleted) {
		final int newIndex = this.simpleASCIIHashFunction(stringToBeDeleted, this.hashTable.length);
		if (this.hashTable[newIndex] != null && this.hashTable[newIndex].contains(stringToBeDeleted)) {
			System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable.");
			this.hashTable[newIndex].remove(stringToBeDeleted);
			System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !");
		} else {
			System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
		}
	}

	// Deletes entire HashTable
	public void deleteHashTable() {
		this.hashTable = null;
		System.out.println("Successfully deleted HashTable !");
	}
}
