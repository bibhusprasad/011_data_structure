package s3_c3_node;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	public Map<Character, TrieNode> children;
	public boolean endOfWord;

	// Constructor
	public TrieNode() {
		this.children = new HashMap<>();
		this.endOfWord = false;
	}
}
