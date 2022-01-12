package wordsearch;

public class WordSearch {

	public static void main(String[] args) {

		char[][] field = { { 'K', 'Ä', 'S', 'E', 'M', 'S', 'M', 'E', 'C', 'B' },
						   { 'Z', 'U', 'C', 'K', 'E', 'R', 'R', 'E', 'I', 'S' },
						   { 'Z', 'H', 'E', 'I', 'E', 'R', 'H', 'F', 'G', 'J' },
						   { 'F', 'I', 'S', 'C', 'H', 'S', 'M', 'R', 'L', 'O' },
						   { 'H', 'O', 'N', 'I', 'G', 'S', 'R', 'T', 'R', 'G' },
						   { 'M', 'A', 'R', 'M', 'E', 'L', 'A', 'D', 'E', 'H' },
						   { 'B', 'U', 'T', 'T', 'E', 'R', 'U', 'A', 'N', 'U' },
						   { 'N', 'U', 'D', 'E', 'L', 'N', 'E', 'H', 'M', 'R' },
						   { 'W', 'U', 'R', 'S', 'T', 'B', 'R', 'O', 'T', 'T' },
						   { 'A', 'F', 'F', 'L', 'E', 'I', 'S', 'C', 'H', 'F' } };

		String Searching_Word = "fleisch".toUpperCase();
		System.out.println(solve(field, Searching_Word));
	}

	public static int solve(char[][] field, String Searching_Word) {

		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					for (int k = 0; k < Searching_Word.length(); k++) {
						try {
							if (field[i][j + k] == Searching_Word.charAt(k)) {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i][j + k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}
							} else {
								break;
							}
						} catch (Exception f) {

						}
					}
					// System.out.println(Possible_Solution);
					// System.out.println();
					Possible_Solution = "";

				}
			}

		}
		return -1;

	}

}
