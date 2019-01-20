import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The utilities class contains the main functions that we will use to count word occurrences and create our histogram
 */
class Utilities {

    /**
     * This function uses a string and a list of Word objects to search for the string in the list. This function is
     * mainly used in the createSortedList function in order to increment the count of an existing word.
     * @param list Word object list to be searched
     * @param word specific word string that we want to find in the list of objects
     * @return the index of the word; if not found returns -1
     */
    public static int checkListForWord(List<Word> list, String word){
        for (Word w: list){
            if (w.getWord().equals(word)){
                return list.indexOf(w);
            }
        }

        return -1;
    }

    /**
     * This function will take a completed Word list and output a histogram to a file called "output.txt"
     * It uses StringBuilder to create the entire output in a single string, then that string is
     * written to the output file.
     * @param wordList list of Word objects used to create the histogram output
     * @throws IOException used for opening the output file for writing
     */
    static void printHistogram(List<Word> wordList) throws IOException {
        StringBuilder s = new StringBuilder();
        for (Word w: wordList){

            s.append(String.format("%8s | ", w.getWord()));
            for (int i = 0; i < w.getCount(); i++){
                s.append("=");
            }
            s.append(" (").append(w.getCount()).append(")\n");
        }

        PrintWriter out = new PrintWriter("output.txt");
        out.write(s.toString());
        out.close();

    }

    /**
     * This function contains the main logic of the program, which consists of using the scanner to parse the input,
     * check the wordList for the current word, and either increment that word's count or create a new object to be
     * inserted into the list. After the scanner finishes parsing, the list is sorted and reversed to get the data in
     * ascending order. Finally, we return this list for printing.
     * @param scanner this is the initialized scanner object ready to parse the input
     * @return the sorted list of words and their occurrences contained in Word objects.
     */
    static List<Word> createSortedList(Scanner scanner){

        List<Word> wordList = new ArrayList<>();
        int index, currentCount;
        String word;

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                word = scanner.next().replaceAll("[,.]", "").toLowerCase();
                index = checkListForWord(wordList, word);
                if (index != -1){
                    currentCount = wordList.get(index).getCount();
                    wordList.get(index).setCount(currentCount + 1);
                }else{
                    Word wordObject = new Word(word, 1);
                    wordList.add(wordObject);
                }
            }
        }

        wordList.sort(Comparator.comparing(Word::getCount));
        Collections.reverse(wordList);

        return wordList;
    }

    /**
     * This function created a scanner and initializes it with our file path.
     * @return initialized scanner
     */
    static Scanner initializeScanner(String filepath){

        // set filepath
        File file = new File(filepath);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scanner;
    }
}
