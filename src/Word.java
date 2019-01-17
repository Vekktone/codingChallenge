public class Word {

    private String word;
    private Integer count;

    Word(String word, Integer count){

        this.word = word;
        this.count = count;

    }

    Integer getCount() {
        return count;
    }

    void setCount(Integer count) {
        this.count = count;
    }


    String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
