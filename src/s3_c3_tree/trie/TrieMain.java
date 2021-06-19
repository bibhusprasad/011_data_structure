package s3_c3_tree.trie;

public class TrieMain {

	public static void main(final String[] args) {

		final Trie t = new Trie();

		System.out.println("\n=====CASE 1=====");
		t.insert("bcde");
		t.insert("bckg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bckg");

		System.out.println("\n=====CASE 2=====");
		t.insert("bcde");
		t.insert("bcdefg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcdefg");

		System.out.println("\n=====CASE 3=====");
		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcde");
		t.search("bc");
		t.search("b");

		System.out.println("\n=====CASE 4=====");
		t.insert("bcde");
		t.delete("bcde");
		t.search("bcde");

	}
}
