package Code;

import java.util.ArrayList;
import java.util.Comparator;

public class AutocompleteProvider {
	static trieTree tree = new trieTree();
	
	public static ArrayList<Candidate> getWords(String fragment) { //: returns list of candidates ordered by confidence*
		ArrayList<Candidate> result = tree.possibleWords(fragment);
		//made a comparator to sort based on confidence value
		result.sort(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate e1,
                    Candidate e2) {
                if (e1.getConfidence() < e2.getConfidence())
                	return 1;
                else if (e1.getConfidence() == e2.getConfidence())
                	return 0;
                else 
                	return -1;
            }
        });
		//System.out.println(result);
		return result;
	}
	
    public static void train(String passage) { //: trains the algorithm with the provided passage
    	//split the passage to every word
    	//assuming that every word can only contain letters, numbers, ' , and -
    	String[] words = passage.split("[^\\w'-]");
    	for (int x = 0; x < words.length; x++) {
    		tree.insert(words[x].toLowerCase());
    	}
	}
    
}
