package Code;

import java.util.ArrayList;

public class trieTree {
	private static trieNode root;
	
	//create the root node once the tree is created
	public trieTree() {
		root = new trieNode(' ', null);
	}
	
	//inserts all letters of the word into the tree
	public void insert(String word) {
		char let [] = word.toCharArray();
		trieNode cur = root;
		for (int x = 0; x < let.length; x++) {
			cur.add(let[x]);
			cur = cur.get(let[x]);
		}
		//marks the end of the word in the nodes
		cur.endOfWord();
	}
	
	public ArrayList<Candidate> possibleWords(String fragment) {
		trieNode cur = root;
		//goes to the last part of the fragment to get possible words left
		char let [] = fragment.toCharArray();
		for (int x = 0; x < let.length; x++) {
			cur = cur.get(let[x]);
		}
		return cur.possibleWords();
	}
}
