import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Utilities {

    private static int checkListForWord(List<Word> list, String word){
        for (Word w: list){
            if (w.getWord().equals(word)){
                return list.indexOf(w);
            }
        }

        return -1;
    }

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

    static Scanner initializeScanner(){

        // set filepath
        File file = new File("C:\\Users\\M108212\\IdeaProjects\\codingChallenge\\input.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scanner;
    }
}
