import java.util.Scanner;
import java.util.List;
import java.io.IOException;

/**
 * Write a program that reads in a paragraph form a file (input.txt) and generates a histogram
 * of the words used, sorted from most occurrences to least. The output will consist of the word followed by a
 * pipe character ("|"), a number of equal signs that are proportional to the number of occurrences found in the
 * text, and the number of occurrences itself. Have the program read in the paragraph defined in
 * the input.txt file below and generate a histograph stored in an output file (output.txt).
 */
public class Main {

    /**
     * The main program simply creates the scanner to parse the file,
     * fills the word list using the input file, and prints the histogram into the
     * output file.
     * @param args should be empty
     * @throws IOException used for the file output function
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = Utilities.initializeScanner(ApplicationConstants.FILEPATH);
        List<Word> wordList = Utilities.createSortedList(scanner);
        Utilities.printHistogram(wordList);
    }
}
