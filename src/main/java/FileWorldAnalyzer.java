import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWorldAnalyzer  {

	FilePartReader fileReader = new FilePartReader();

	public FileWorldAnalyzer() throws IOException {
	}


	public List<String> getWordsOrderedAlphabetically () throws IOException {
		List<String> linesFromile;
		linesFromile = Arrays.asList(fileReader.readLines().split("\\s+"));
		Collections.sort(linesFromile);
		return linesFromile;
	}

	public List<String> getWordsContainingSubstring (String subString ) throws IOException {
		List<String> linesFromile;
		List <String> result = new ArrayList<>();
		linesFromile = Arrays.asList(fileReader.readLines().split("\\s+"));
		linesFromile.forEach((String line) -> {
			if (line.contains(subString)) {
				result.add(line);
			}
		});
		return result;
	}

	public List<String> getStringsWhichPalindromes () throws IOException {
		List<String> linesFromile;
		List <String> result = new ArrayList<>();
		linesFromile = Arrays.asList(fileReader.readLines().split("\\s+"));
		linesFromile.forEach((String line) -> {
			if (isPalindrome(line)) {
				linesFromile.add(line);
			}
		});
		return linesFromile;
	}

	static boolean isPalindrome(String str)
	{

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters toc compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}



}