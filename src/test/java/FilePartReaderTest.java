import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
	FilePartReader  fileReader = new FilePartReader();


	@Test
	void setup() {
		assertThrows(IllegalArgumentException.class, () -> fileReader.setup("src/testfile/testfile.txt", 1, 0) );
	}


	@Test
	void getFilePath() throws IOException {
		assertEquals("filePath", fileReader.getFilePath());

	}

	@Test
	void getFromLine() {
		assertEquals(0, fileReader.getFromLine());

	}

	@Test
	void getToLine() {
		assertEquals(-1, fileReader.getToLine());
	}

	@Test
	void read() throws IOException {
		fileReader.setup("src/testfile/testfile.txt",1,1);
		String expectedR = "linia 1 ";
		assertEquals(expectedR, fileReader.readLines());
	}

	@Test
	void readLines() throws IOException {
		fileReader.setup("src/testfile/testfile.txt",1,4);
		String expected = "linia 1 linia 2 linia 3 linia 4 ";
		assertEquals(expected, fileReader.readLines());
	}
}