package by.education.sorting.isunique;

public class IsUniqueRunner {

	// ASCII or Unicode string?
	private final static String UNIQUE_CHARACTERS_IN_STRING = "abcd";
	private final static String DUPLICATED_CHARACTERS_IN_STRING = "abcad";
	

	public static void main(String[] args) {

		//boolean result = new IsUniqueRunner().isUniqueCharacter(DATA);
		
		boolean result = new IsUniqueRunner().isStringHoldsUniqueCharacters(UNIQUE_CHARACTERS_IN_STRING);
		System.out.println("(" + UNIQUE_CHARACTERS_IN_STRING + "): " + result);
		
		result = new IsUniqueRunner().isStringHoldsUniqueCharacters(DUPLICATED_CHARACTERS_IN_STRING);		
		System.out.println("(" + DUPLICATED_CHARACTERS_IN_STRING + "): " + result);
		
		result = new IsUniqueRunner().isStringHoldsUniqueCharactersBySortingItems(DUPLICATED_CHARACTERS_IN_STRING);		
		System.out.println("By sorting (" + DUPLICATED_CHARACTERS_IN_STRING + "): " + result);
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

	/**
	 * My implementation.
	 * 
	 * @param str
	 * @return
	 */
	private boolean isStringHoldsUniqueCharacters(String str) {
		
		if(str.length() > 128) {
			return false;
		}
		
		boolean[] char_array = new boolean[128];
		
		return str.chars().noneMatch(characterCode -> isCharacterNonUnique(characterCode, char_array));
	}
	
	private boolean isCharacterNonUnique(int characterCode, boolean[] char_array) {
		
		if(char_array[characterCode]) {
			return true;
		}
		
		char_array[characterCode] = true;
		
		return false;
	}
	
	private boolean isStringHoldsUniqueCharactersBySortingItems(String str) {
		
		int[] symbols = {-1};		
		
		return str.chars().sorted().noneMatch(x -> {
			boolean result = (x == symbols[0]);
			
			symbols[0] = x;
			
			return result;			
		});
	}
}
