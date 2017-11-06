package concatenation;

import java.util.ArrayList;

public class ConcatenatedWords {
    public ArrayList<String> concatenatedWords;
    public String currentWord;

    public ConcatenatedWords() {
        concatenatedWords = new ArrayList<>();
    }

    /**
     * Method that returns the longest concatenated word from the list of
     * concatenated words.
     * @return
     */
    public String getFirstLongestConcatenatedWord() {
        return concatenatedWords.get(0);
    }

    /**
     * Method that returns the second longest concatenated word from the list of
     * concatenated words.
     * @return
     */
    public String getSecondLongestConcatenatedWord() {
        return concatenatedWords.get(1);
    }

    /**
     * Method that returns the number of concatenated words in the list of
     * concatenated words.
     * @return
     */
    public int getNumberOfConcatenatedWords() {
        return concatenatedWords.size();
    }
}
