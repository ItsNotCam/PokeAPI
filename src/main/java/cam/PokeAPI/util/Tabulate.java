package cam.PokeAPI.util;

public class Tabulate {
  public static String tabulate(String[] headers, String[][] data) {
    // A list of the longest columns in each row
    int[] longestColumnLengths = getLongestColumnLengths(headers, data);

    // Generate the separator
    String separator = getSeparator(longestColumnLengths);

    // Create the output
    String output = separator + "\n";

    // Add the headers
    output += tabulateRow(headers, longestColumnLengths) + String.format("\n%s\n", separator);

    // Add the rows
    for (String[] row : data) {
      output = output.concat(tabulateRow(row, longestColumnLengths) + "\n");
    }

    // Done :)
    return output + separator;
  }
  static String getSeparator(int[] longestColumnLengths) {
    // Create the separator
    String separator = "+ ";
    for(int padIdx = 0; padIdx < longestColumnLengths.length; padIdx++) {
      int numDashes = longestColumnLengths[padIdx] + 2;
      for(int colIdx = 0; colIdx < numDashes; colIdx++) {
        separator = separator.concat("-");
      }
    }

    return separator + " +";
  }

  static int[] getLongestColumnLengths(String[] headers, String[][] data) {
    int[] longestColumnLengths = new int[data[0].length];
    for(int rowIdx = 0; rowIdx < data.length; rowIdx++) {
      for(int colIdx = 0; colIdx < data[rowIdx].length; colIdx++) {
        int length = Math.max(
          data[rowIdx][colIdx].length(),
          headers[colIdx].length()
        );
        if(length > longestColumnLengths[colIdx]) {
          longestColumnLengths[colIdx] = length;
        }
      }
    }

    return longestColumnLengths;
  }

  static String tabulateRow(String[] cols, int[] longestColumnLengths) {
    String output = "";
    for(int colIdx = 0; colIdx < cols.length; colIdx++) {
      int curWidth = longestColumnLengths[colIdx];
      String format = (colIdx == 0 ? "| " : " ") + "%-" + curWidth + "s |";
      output = output.concat(String.format(format, cols[colIdx]));
    }
    return output;
  }
}
