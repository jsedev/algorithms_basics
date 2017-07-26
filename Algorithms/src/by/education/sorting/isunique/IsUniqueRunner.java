package by.education.sorting.isunique;

public class IsUniqueRunner {

	// ASCII or Unicode string?
	private final static String DATA = "abcd";

	public static void main(String[] args) {

		boolean result = new IsUniqueRunner().isUniqueCharacter(DATA);

		System.out.println(result);
	}

	private boolean isUniqueCharacter(String str) {

		// what should be if string is null?

		// this is true for ACSII. ASCII holds codes from 0 to 128.
		//
		if (str.length() > 128) {
			return false;
		}

		boolean[] char_set = new boolean[128];

		boolean result = str.chars().anyMatch(i -> {
			System.out.println((char) i);

			boolean isFound = char_set[i];

			if (isFound) {
				return true;
			}
			
			char_set[i] = true;

			return false;
		});

		return result;
	}

}
