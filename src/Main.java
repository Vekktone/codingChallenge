import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        System.out.println("Histogram coding challenge");

        List<Word> wordList = new ArrayList<>();
        int index, currentCount;
        String word;

        // set filepath
        File file = new File("C:\\Users\\M108212\\IdeaProjects\\codingChallenge\\input.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

        for (Word w : wordList) {
            System.out.println("<" + w.getWord() + "," + w.getCount() + ">");
        }

        printHistogram(wordList);

    }

    private static int checkListForWord(List<Word> list, String word){
        for (Word w: list){
            if (w.getWord().equals(word)){
                return list.indexOf(w);
            }
        }

        return -1;
    }

    private static void printHistogram(List<Word> wordList){

    }
}
