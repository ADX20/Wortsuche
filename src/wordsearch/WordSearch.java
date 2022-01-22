package wordsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws Exception {

		char[][] field = { { 'K', 'Ä', 'S', 'E', 'H', 'S', 'M', 'E', 'C', 'B' },
				{ 'Z', 'U', 'C', 'K', 'A', 'R', 'R', 'E', 'I', 'S' },
				{ 'Z', 'H', 'E', 'I', 'S', 'R', 'H', 'F', 'G', 'J' },
				{ 'F', 'I', 'S', 'C', 'H', 'S', 'M', 'R', 'L', 'O' },
				{ 'H', 'O', 'N', 'I', 'G', 'S', 'R', 'T', 'R', 'G' },
				{ 'M', 'A', 'R', 'M', 'E', 'L', 'A', 'D', 'E', 'H' },
				{ 'B', 'U', 'T', 'T', 'E', 'R', 'U', 'A', 'N', 'U' },
				{ 'N', 'U', 'D', 'E', 'L', 'N', 'E', 'H', 'M', 'R' },
				{ 'W', 'U', 'R', 'S', 'T', 'B', 'R', 'O', 'T', 'T' },
				{ 'A', 'F', 'F', 'L', 'E', 'I', 'S', 'C', 'H', 'F' } };

		FileInput(field);

	}

	public static void FileInput(char[][] field) {

		String Searching_Word[] = {};
		String FilePath = System.getProperty("user.dir") + "\\src\\wordsearch\\words";

		File file = new File(FilePath);
		Scanner sc;
		try {
			sc = new Scanner(file);
			int counter = 0;
			while (sc.hasNextLine()) {
				//System.out.println(sc.nextLine());
				try {
				solve_main(field,((String)sc.nextLine()).toUpperCase());
				}catch(Exception f) {
					break;
				}
			}
			//System.out.println(counter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void solve_main(char[][] field, String word) {
		//System.out.println("debig");
		//System.out.println(word);
		if(solve_leftToRight(field, word) != -1) { System.out.println("Found Word: "+ word +" using Left-to-Right in line: " + solve_leftToRight(field,word));}
		if(solve_rightToLeft(field, word) != -1) System.out.println("Found Word: "+ word +"  using Right-to-Left in line: " + solve_rightToLeft(field,word));
		if(solve_topToBottom(field, word) != -1) System.out.println("Found Word: "+ word +" using Top-to-Bottom in line: " + solve_topToBottom(field,word));
		if(solve_bottomToTop(field, word) != -1) System.out.println("Found Word: "+ word +" using Bottom-to-Top in line: " + solve_bottomToTop(field,word));
		if(solve_TopLeftToBottomRight(field, word) != -1) System.out.println("Found Word: "+ word +" using TopLeft-to-BottomRight in line: " + solve_TopLeftToBottomRight(field,word));
		if(solve_BottomLeftToTopRight(field, word) != -1) System.out.println("Found Word: "+ word +" using BottomLeft-to-TopRight in line: " + solve_BottomLeftToTopRight(field,word));
		if(solve_TopRightToBottomLeft(field, word) != -1) System.out.println("Found Word: "+ word +" using TopRight-to-BottomLeft in line: " + solve_TopRightToBottomLeft(field,word));
		if(solve_BottomRightToTopLeft(field, word) != -1) System.out.println("Found Word: "+ word +" using Bottomright-to-TopLeft in line: " + solve_BottomRightToTopLeft(field,word));
		else if(solve_leftToRight(field, word) == -1 && solve_rightToLeft(field, word) == -1 && solve_topToBottom(field, word) == -1 && solve_bottomToTop(field, word) == -1 && solve_TopLeftToBottomRight(field, word) == -1 && solve_BottomLeftToTopRight(field, word) == -1 && solve_TopRightToBottomLeft(field, word) == -1 && solve_BottomRightToTopLeft(field, word) == -1) System.out.println("The Word: " +word+" has not been found");
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
					} catch (Exception e) {
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
					} catch (Exception e) {
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
					try {
						if (field[i + 1][j] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i + k][j];
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
					} catch (Exception e) {
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
					try {
						if (field[i - 1][j] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i - k][j];
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
					} catch (Exception e) {
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
					try {
						if (field[i + 1][j + 1] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i + k][j + k];
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
					} catch (Exception e) {
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
					try {
						if (field[i - 1][j + 1] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i - k][j + k];
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
					} catch (Exception e) {
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
					try {
						if (field[i + 1][j - 1] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i + k][j - k];
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
					} catch (Exception e) {
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
					try {
						if (field[i - 1][j - 1] == Searching_Word.charAt(1)) {

							for (int k = 0; k < Searching_Word.length(); k++) {
								try {
									// System.out.print(field[i][(j + k)]);
									Possible_Solution += field[i - k][j - k];
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
					} catch (Exception e) {
						break;
					}
				}

			}

		}

		return -1;
	}

}
