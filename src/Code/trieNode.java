package Code;

import java.util.ArrayList;

public class trieNode {
	public boolean isWord;
	public int occurances;
	public char letter;
	//dynamically allocates memory based on data needed
	public ArrayList<trieNode> children = new ArrayList<trieNode>();
	public trieNode parent;
	
	//Every node must have a parent element and letter that it stores
	public trieNode(char l, trieNode p) {
		letter = l;
		parent = p;
	}
	
	//adds to the children list
	public void add(char c) {
		//only adds the child if it already doesnt exist
		boolean exists = false;
		for (int x = 0; x < children.size(); x++) {
			if (c == children.get(x).getChar())
				exists = true;
		}
		if (!exists)
			children.add(new trieNode(c, this));
	}
	
	//gets child node that contains the specific character
	public trieNode get(char c) {
		for (int x = 0; x < children.size(); x++) {
			if (c == children.get(x).getChar())
				return children.get(x);
		}
		System.out.println("doesnt exists");
		return null;
	}
	
	public char getChar() {
		return letter;
	}
	
	public boolean isWord() {
		return isWord;
	}
	
	//increments how many times the word has been used and marks end of word
	public void endOfWord() {
		if (isWord) 
			occurances++;
		else {
			isWord = true;
			occurances++;
		}
	}
	
	//gets all possible words that stem from this specific node
	public ArrayList<Candidate> possibleWords() {
		ArrayList<Candidate> pWords = new ArrayList<Candidate>();
		//if the node is the end of a word add the word to the list
		if (isWord()) {
			pWords.add(new Candidate(Word(), occurances));
		}
		for (int x = 0; x < children.size(); x++) {
			// go to the children to get all words
			ArrayList<Candidate> temp = new ArrayList<Candidate>();
			temp = children.get(x).possibleWords();
			//join all the arraylists together to create updated list
			for (int y = 0; y < temp.size(); y++) {
				pWords.add(temp.get(y));
			}
		}
		return pWords;
	}
	
	//gets the word by going up the tree
	//another way to improve efficiecy is to store the entire word up to this point
	public String Word() {
		if (parent != null)
			return parent.Word() + String.valueOf(letter);
		else 
			return "";
	}
	
	//mainly for debugging purposes
	public void print(int level) {
		System.out.print("level = "+level);
		System.out.print("   letter = "+letter+" children = "+children.size());
		System.out.print("  # of times "+occurances);
		for (int x = 0; x < children.size(); x++) {
			System.out.print("   children = "+children.get(x).getChar());
			
		}
		System.out.println();
		level = level + 1;
		for (int x = 0; x < children.size(); x++) {
			children.get(x).print(level);
		}
		
	}
	
}
