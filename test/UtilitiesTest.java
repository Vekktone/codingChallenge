import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    /**
     * This method will check a list and verify that if a specified word doesn't exist in the list,
     * -1 will be returned
     */
    @Test
    void checkWordListForNonExistentItem() {
        String testWord = "hello";
        List<Word> wordList = new ArrayList<>();
        Word word1 = new Word("Cat", 1);
        Word word2 = new Word("Dog", 1);
        Word word3 = new Word("Rat", 1);
        Word word4 = new Word("Hat", 1);

        wordList.add(word1);
        wordList.add(word2);
        wordList.add(word3);
        wordList.add(word4);

        assertEquals(-1, Utilities.checkListForWord(wordList, testWord));

    }

    /**
     * This method verifies that a newly created list will be sorted correctly. It only cares about the
     * words in the list, not their counts.
     */
    @Test
    void checkListForWordsInOrder() {
        List<Word> artificialSortedList = new ArrayList<>();
        Word word1 = new Word("cat", 4);
        Word word2 = new Word("dog", 3);
        Word word3 = new Word("rat", 2);
        Word word4 = new Word("hat", 1);

        artificialSortedList.add(word1);
        artificialSortedList.add(word2);
        artificialSortedList.add(word3);
        artificialSortedList.add(word4);

        Scanner testScanner = Utilities.initializeScanner(ApplicationConstants.TESTFILEPATH);
        List<Word> naturalSortedList = Utilities.createSortedList(testScanner);

        int i = 0;
        for (Word w: naturalSortedList){
            assert w.getWord().equals(artificialSortedList.get(i).getWord());
            i++;
        }
    }

}