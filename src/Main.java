import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        System.out.println("Histogram coding challenge");

        Map<String, Integer> wordMap = new HashMap<>();
        Integer counter;
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
                counter = wordMap.get(word);
                wordMap.put(word, (counter == null) ? 1 : counter + 1);
            }
        }

        printMap(wordMap);
    }

    //pretty print a map
    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("<" + entry.getKey()
                    + ", " + entry.getValue() + ">");
        }
    }
}
