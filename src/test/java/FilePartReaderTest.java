import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

	FilePartReader  filePartReader = new FilePartReader();

	@Test
	void setup() {
		assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/testfile/testfile.txt", 1, 0) );
	}


	@Test
	void getFilePath() {
		assertEquals("filePath", filePartReader.getFilePath());

	}

	@Test
	void getFromLine() {
		assertEquals(0, filePartReader.getFromLine());

	}

	@Test
	void getToLine() {
		assertEquals(-1, filePartReader.getToLine());
	}

	@Test
	void read() throws IOException {
		filePartReader.setup("src/testfile/testfile.txt",1,1);
		String expectedR = "linia 1 ";
		assertEquals(expectedR, filePartReader.readLines());
	}

	@Test
	void readLines() throws IOException {
		filePartReader.setup("src/testfile/testfile.txt",1,4);
		String expected = "linia 1 linia 2 linia 3 linia 4 ";
		assertEquals(expected, filePartReader.readLines());
	}
}