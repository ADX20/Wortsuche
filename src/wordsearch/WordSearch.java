package wordsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    static char[][] field;

    public static void main(String[] args) {
        /*
        char[][] field = {
                {'E', 'S', 'Ä', 'K', 'H', 'S', 'M', 'U', 'C', 'B'},
                {'Z', 'U', 'C', 'K', 'A', 'R', 'R', 'r', 'I', 'S'},
                {'Z', 'H', 'E', 'T', 'S', 'R', 'Z', 'F', 'G', 'J'},
                {'F', 'I', 'S', 'C', 'H', 'S', 'K', 'I', 'L', 'O'},
                {'H', 'O', 'N', 'T', 'G', 'S', 'E', 'T', 'R', 'G'},
                {'M', 'A', 'R', 'T', 'E', 'L', 'U', 'D', 'E', 'H'},
                {'B', 'U', 'T', 'T', 'S', 'R', 'Z', 'A', 'N', 'U'},
                {'N', 'U', 'D', 'E', 'L', 'A', 'E', 'H', 'M', 'R'},
                {'W', 'U', 'R', 'S', 'T', 'B', 'O', 'O', 'T', 'T'},
                {'A', 'F', 'F', 'L', 'E', 'O', 'S', 'T', 'H', 'F'}
         };
         */
        field = readFieldFromFile("map.txt");

        findWordsFromFile("words.txt");
    }

    private static char[][] readFieldFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            List<char[]> map = new ArrayList<>();
            while (reader.ready()) {
                map.add(reader.readLine().toCharArray());
            }
            return map.toArray(new char[0][]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void findWordsFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.ready()) {
                solve_main(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve_main(String word) {
        word = word.toUpperCase();

        FoundResult result = searchInRow(word);
        if (result == null) {
            result = searchInCol(word);
            if (result == null) {
                result = searchInDiagonalRight(word);
                if (result == null) {
                    result = searchInDiagonalLeft(word);
                }
            }
        }

        if (result == null) {
            System.out.println("The Word: " + word + " was not found");
        } else {
            System.out.println(result);
        }
    }

    private static FoundResult checkWordInSlice(String word, StringBuilder rowBuffer, int position, int other, FoundResult.FoundType type) {
        if (rowBuffer.length() >= word.length()) {
            String bufferSlice = rowBuffer.substring(Math.max(0, rowBuffer.length() - word.length()));
            if (bufferSlice.equals(word)) {
                return new FoundResult(word, false, type, position, other, other + word.length());
            }
            if (new StringBuilder(bufferSlice).reverse().toString().equals(word)) {
                return new FoundResult(word, true, type, position, other - (word.length() - 1), other);
            }
        }
        return null;
    }

    public static FoundResult searchInRow(String word) {
        for (int y = 0; y < field.length; y++) {
            StringBuilder rowBuffer = new StringBuilder();
            for (int x = 0; x < field[y].length; x++) {
                rowBuffer.append(field[y][x]);
                FoundResult result = checkWordInSlice(word, rowBuffer, y, x, FoundResult.FoundType.ROW);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    public static FoundResult searchInCol(String word) {
        for (int x = 0; x < field[0].length; x++) {
            StringBuilder rowBuffer = new StringBuilder();
            for (int y = 0; y < field.length; y++) {
                rowBuffer.append(field[y][x]);
                FoundResult result = checkWordInSlice(word, rowBuffer, x, y, FoundResult.FoundType.COLUMN);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    public static FoundResult searchInDiagonalRight(String word) {
        if (field.length >= word.length()) {
            for (int y = field.length - word.length(); y >= 0; y--) {
                StringBuilder rowBuffer = new StringBuilder();
                for (int x = 0; x < field[y].length; x++) {
                    for (int i = 0; i < field.length - y; i++) {
                        if (y + i < field.length && x + i < field[y].length) {
                            rowBuffer.append(field[y + i][x + i]);
                            FoundResult result = checkWordInSlice(word, rowBuffer, y, x + i, FoundResult.FoundType.DIAGONAL_RIGHT);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public static FoundResult searchInDiagonalLeft(String word) {
        if (field.length >= word.length()) {
            for (int y = field.length - word.length(); y >= 0; y--) {
                StringBuilder rowBuffer = new StringBuilder();
                for (int x = field[y].length - 1; x >= 0; x--) {
                    for (int i = 0; i < field.length - y; i++) {
                        if (y - i >= 0 && x - i >= 0) {
                            rowBuffer.append(field[y + i][x - i]);
                            FoundResult result = checkWordInSlice(word, rowBuffer, y, x + i - word.length() / 2, FoundResult.FoundType.DIAGONAL_LEFT);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public record FoundResult(String word, boolean reversed, FoundType type, int position, int startPosition,
                              int endPosition) {
        @Override
        public String toString() {
            return "Found Word: " + word + " using " + type.toString(reversed) + " " + type.position + "=" + position + " from " + startPosition + " to " + endPosition;
        }

        public enum FoundType {
            ROW("Line", "Left-to-Right", "Right-to-Left"),
            COLUMN("Column", "Top-to-Bottom", "Bottom-to-Top"),
            DIAGONAL_RIGHT("Line", "TopLeft-to-BottomRight", "BottomRight-to-TopLeft"),
            DIAGONAL_LEFT("Line", "TopRight-to-BottomLeft", "BottomLeft-to-TopRight");

            public final String position;
            private final String normal, reversed;

            FoundType(String position, String normal, String reversed) {
                this.position = position;
                this.normal = normal;
                this.reversed = reversed;
            }

            public String toString(boolean reversed) {
                return reversed ? this.reversed : normal;
            }
        }
    }

}
