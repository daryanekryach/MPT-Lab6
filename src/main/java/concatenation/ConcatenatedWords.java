package concatenation;

import java.util.ArrayList;

class ConcatenatedWords {
     ArrayList<String> concatenatedWords;
     String currentWord;

    ConcatenatedWords(){
        concatenatedWords = new ArrayList<>();
    }

    String getFirstLongestConcatenatedWord() {
        return concatenatedWords.get(0);
    }

    String getSecondLongestConcatenatedWord() {
        return concatenatedWords.get(1);
    }

    int getNumberOfConcatenatedWords() {
        return concatenatedWords.size();
    }
}
