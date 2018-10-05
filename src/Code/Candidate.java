package Code;

public class Candidate {
	private String word;
	private int confidence;
	
	public Candidate(String w, int c) {
		word = w;
		confidence = c;
	}
	
	public String getWord() {
		return word; 
	}
	
	public int getConfidence() {
		return confidence;
	}
	
	public String toString() {
		return word+" ("+confidence+")";
	}
}
