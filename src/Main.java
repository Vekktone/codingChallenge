import java.util.Scanner;
import java.util.List;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = Utilities.initializeScanner();
        List<Word> wordList = Utilities.createSortedList(scanner);
        Utilities.printHistogram(wordList);
    }
}
