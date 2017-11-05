package concatenation;

import java.util.ArrayList;

public class ConcatenatedWords {
    public ArrayList<String> concatenatedWords;
    public String currentWord;

    public ConcatenatedWords() {
        concatenatedWords = new ArrayList<>();
    }

    public String getFirstLongestConcatenatedWord() {
        return concatenatedWords.get(0);
    }

    public String getSecondLongestConcatenatedWord() {
        return concatenatedWords.get(1);
    }

    public int getNumberOfConcatenatedWords() {
        return concatenatedWords.size();
    }
}
