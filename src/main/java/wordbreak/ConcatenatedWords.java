package wordbreak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

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
