import java.util.Scanner;
import java.util.List;
import java.io.IOException;

public class Main {

    /**
     * The main program simply creates the scanner to parse the file,
     * fills the word list using the input file, and prints the histogram into the
     * output file.
     * @param args should be empty
     * @throws IOException used for the file output function
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = Utilities.initializeScanner();
        List<Word> wordList = Utilities.createSortedList(scanner);
        Utilities.printHistogram(wordList);
    }
}
