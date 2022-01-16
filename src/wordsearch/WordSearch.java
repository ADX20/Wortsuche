package wordsearch;

public class WordSearch {

	public static void main(String[] args) {

		char[][] field = { { 'K', 'Ä', 'S', 'E', 'H', 'S', 'M', 'E', 'C', 'B' },
				{ 'Z', 'U', 'C', 'K', 'A', 'R', 'R', 'E', 'I', 'S' },
				{ 'Z', 'H', 'E', 'I', 'S', 'R', 'H', 'F', 'G', 'J' },
				{ 'F', 'I', 'S', 'C', 'E', 'S', 'M', 'R', 'L', 'O' },
				{ 'H', 'O', 'N', 'I', 'G', 'S', 'R', 'T', 'R', 'G' },
				{ 'M', 'A', 'R', 'M', 'E', 'L', 'A', 'D', 'E', 'H' },
				{ 'B', 'U', 'T', 'T', 'E', 'R', 'U', 'A', 'N', 'U' },
				{ 'N', 'U', 'D', 'E', 'L', 'N', 'E', 'H', 'M', 'R' },
				{ 'W', 'U', 'R', 'S', 'T', 'B', 'R', 'O', 'T', 'T' },
				{ 'A', 'F', 'F', 'L', 'E', 'I', 'S', 'C', 'H', 'F' } };

		String Searching_Word = "fthu".toUpperCase();
		
		System.out.println("Left to right " + solve_leftToRight(field, Searching_Word));
		System.out.println("Right to left " + solve_rightToLeft(field, Searching_Word));
		
		System.out.println("Top to bottom " + solve_topToBottom(field, Searching_Word));
		System.out.println("Bottom to Top " + solve_bottomToTop(field, Searching_Word));
		
		System.out.println("Top Left to Bottom Right " + solve_TopLeftToBottomRight(field,Searching_Word));
		System.out.println("Bottom Left to Top Right " + solve_BottomLeftToTopRight(field,Searching_Word));
		
		System.out.println("Top Right to Bottom Left " + solve_TopRightToBottomLeft(field,Searching_Word));
		System.out.println("Bottom Right to Top Left " + solve_BottomRightToTopLeft(field,Searching_Word));
	}

	public static int solve_leftToRight(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try {
					if (field[i][j + 1] == Searching_Word.charAt(1)) {
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i][j + k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	public static int solve_rightToLeft(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try {
					if (field[i][j - 1] == Searching_Word.charAt(1)) {
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i][j - k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	

	public static int solve_topToBottom(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i+1][j] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i+k][j];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	public static int solve_bottomToTop(char[][] field, String Searching_Word) {

		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i-1][j] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i-k][j];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}

	public static int solve_TopLeftToBottomRight(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i+1][j+1] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i+k][j+k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	public static int solve_BottomLeftToTopRight(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i-1][j+1] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i-k][j+k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	
	public static int solve_TopRightToBottomLeft(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i+1][j-1] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i+k][j-k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}
	public static int solve_BottomRightToTopLeft(char[][] field, String Searching_Word) {


		String Possible_Solution = "";
		for (int i = 0; i < field.length; i++) {
			// System.out.println(field[i].length);
			for (int j = 0; j < field[i].length; j++) {
				char character = Searching_Word.charAt(0);
				if (field[i][j] == character) {
					try{
						if (field[i-1][j-1] == Searching_Word.charAt(1)) {
					
						for (int k = 0; k < Searching_Word.length(); k++) {
							try {
								// System.out.print(field[i][(j + k)]);
								Possible_Solution += field[i-k][j-k];
								if (Searching_Word.equals(Possible_Solution)) {
									try {
										return i + 1;
									} catch (Exception e) {
										return i;
									}
								}

							} catch (Exception f) {

							}
						}
						// System.out.println(Possible_Solution);
						// System.out.println();
						Possible_Solution = "";

					}
					}catch(Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}	
	
	
}

