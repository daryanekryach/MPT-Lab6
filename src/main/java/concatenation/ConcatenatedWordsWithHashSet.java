package concatenation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Class ConcatenatedWordsWithHashSet inherits ConcatenatedWords and implements
 * searching for the longest concatenated word with the use of HashSet.
 */
public class ConcatenatedWordsWithHashSet extends ConcatenatedWords {
    private HashSet<String> allWords;

    public ConcatenatedWordsWithHashSet() {
        allWords = new HashSet<>();
    }

    /**
     * Method that sets all variables within class to null with purpose of
     * disposing memory.
     */
    public void free() {
        allWords = null;
        concatenatedWords = null;
    }

    /**
     * Method that reads file line by line and each line adds to the HashSet.
     * @param path - path to the file.
     * @throws IOException
     */
    public void readFileToHashSet(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(word -> allWords.add(word));
        } catch (Exception e) {
            System.out.println("Problem occurred while reading your file : " + e);
        }
    }

    /**
     * Method that checks if the word is concatenated by dividing it into
     * prefix and suffix, and then recursively checks if the current part
     * is in set of words.
     * @param word - word that needs to be checked.
     */
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

    /**
     * Method that looks for all concatenated words in HashSet and in the end
     * sorts the ArrayList of concatenated words by length.
     * @return
     */
    public boolean findConcatenatedWords() {
        for (String word : allWords) {
            currentWord = word;
            checkForConcatenation(word);
        }
        concatenatedWords.sort(Comparator.comparing(String::length).reversed());
        return true;
    }

}
