/**
 * The Word class is used to store a word and its respective number of occurrences. It only has two fields, word and
 * count, and also contains basic getter and setter methods as well as a basic constructor.
 */
public class Word {

    private String word;
    private Integer count;

    /**
     *
     * @param word string of the word we want to create
     * @param count its initial number of occurrences; this will be 1
     */
    Word(String word, Integer count){

        this.word = word;
        this.count = count;

    }

    /**
     * gets the count/occurrences for a word
     * @return count of occurrences for this word
     */
    Integer getCount() {
        return count;
    }

    /**
     * sets the count/occurrences for a word
     * @param count the number we want to set the count to
     */
    void setCount(Integer count) {
        this.count = count;
    }

    /**
     * gets the word string for this Word object
     * @return the string for the Word object
     */
    String getWord() {
        return word;
    }

    /**
     * sets the word string for this Word object
     * @param word the string we want to set this Word object to
     */
    public void setWord(String word) {
        this.word = word;
    }
}
