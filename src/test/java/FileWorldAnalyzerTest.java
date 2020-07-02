import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWorldAnalyzerTest {

	private FilePartReader filePartReader = new FilePartReader();
	private FileWorldAnalyzer fileWorldAnalyzer = new FileWorldAnalyzer(filePartReader);


	@Test
	void getWordsOrderedAlphabetically() throws IOException {
		filePartReader.setup("src/testfile/testfile.txt",1,2);
		assertEquals(Arrays.asList("1", "2", "linia", "linia"), fileWorldAnalyzer.getWordsOrderedAlphabetically());
	}

	@Test
	void getWordsContainingSubstring() throws IOException {
		filePartReader.setup("src/testfile/testfile.txt",1,2);
		assertEquals(Arrays.asList("linia", "linia"), fileWorldAnalyzer.getWordsContainingSubstring("li"));
	}

	@Test
	void getStringsWhichPalindromes() throws IOException {
		filePartReader.setup("src/testfile/testfile.txt",5,5);
		assertEquals(Arrays.asList("axa"), fileWorldAnalyzer.getStringsWhichPalindromes());
	}

}