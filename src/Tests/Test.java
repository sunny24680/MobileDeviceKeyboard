package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Code.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		AutocompleteProvider.train("The third thing that I need to tell you is that this thing does not think thoroughly.");
		System.out.println(AutocompleteProvider.getWords("th"));
	}

}
