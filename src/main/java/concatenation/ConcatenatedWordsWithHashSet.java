package concatenation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class ConcatenatedWordsWithHashSet extends ConcatenatedWords {
    private HashSet<String> allWords;

    public ConcatenatedWordsWithHashSet() {
        allWords = new HashSet<>();
    }

    public void free() {
        allWords = null;
        concatenatedWords = null;
    }

    public void readFileToHashSet(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(word -> allWords.add(word));
        } catch (Exception e) {
            System.out.println("Problem occurred while reading your file : " + e);
        }
    }

    private void checkForConcatenation(String word) {
        String prefix;
        String suffix;
        for (int i = 0; i <= word.length() - 1; i++) {
            prefix = word.substring(0, i + 1);
            suffix = word.substring(i + 1, word.length());

            if (allWords.contains(prefix)) {
                if (allWords.contains(suffix)) {
                    concatenatedWords.add(currentWord);
                    break;
                }
                checkForConcatenation(suffix);
            }
        }
    }

    public void findConcatenatedWords() {
        for (String word : allWords) {
            currentWord = word;
            checkForConcatenation(word);
        }
        concatenatedWords.sort(Comparator.comparing(String::length).reversed());
    }

}
