package cam.PokeAPI.util;

public class Tabulate {
  public static String tabulate(String[] headers, String[][] data) {
    // A list of the longest columns in each row
    int[] longestColumnLengths = getLongestColumnLengths(headers, data);

    // Generate the separator
    String separator = generateSeparator(longestColumnLengths);

    // Create the output
    String output = "\n";

    // Add the headers
    output += tabulateRow(headers, longestColumnLengths) + String.format("\n%s\n", separator);

    // Add the rows
    for (String[] row : data) {
      output = output.concat(tabulateRow(row, longestColumnLengths) + "\n");
    }

    // Done :)
    return separator + output + separator;
  }
  static String generateSeparator(int[] longestColumnLengths) {
    String separator = "";
    for(int colIdx = 0; colIdx < longestColumnLengths.length; colIdx++) {
      int curWidth = longestColumnLengths[colIdx];
      String format = (colIdx == 0 ? "+ " : " ") + "%-" + curWidth + "s +";
      separator = separator.concat(
        String.format(format, "-").replace(" ", "-")
      );
    }
    return separator;
  }

  static int[] getLongestColumnLengths(String[] headers, String[][] data) {
    int[] longestColumnLengths = new int[data[0].length];
    for(int rowIdx = 0; rowIdx < data.length; rowIdx++) {
      for(int colIdx = 0; colIdx < data[rowIdx].length; colIdx++) {
        int dataLength = data[rowIdx][colIdx].length();
        int headerLength = headers[colIdx].length();

        int curLength = Math.max(dataLength, headerLength);
        int curLongest = longestColumnLengths[colIdx];
        longestColumnLengths[colIdx] = Math.max(curLength, curLongest);
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
