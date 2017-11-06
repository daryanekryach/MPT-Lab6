package concatenation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Class ConcatenatedWordsWithTrie inherits ConcatenatedWords and implements
 * searching for the longest concatenated word with the use of Trie data
 * structure.
 */
public class ConcatenatedWordsWithTrie extends ConcatenatedWords {
    private Trie trie;
    private ArrayList<String> allWords;

    public ConcatenatedWordsWithTrie() {
        trie = new Trie();
        allWords = new ArrayList<>();
    }

    /**
     * Method that sets all variables within class to null with purpose of
     * disposing memory.
     */
    public void free() {
        trie = null;
        concatenatedWords = null;
        allWords = null;
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

            if (trie.isPresentInTrie(prefix)) {
                if (trie.isPresentInTrie(suffix)) {
                    concatenatedWords.add(currentWord);
                    break;
                }
                checkForConcatenation(suffix);
            }
        }
    }

    /**
     * Method that looks for all concatenated words in Trie and in the end
     * sorts the ArrayList of concatenated words by length.
     * @return
     */
    public void findConcatenatedWords() {
        for (String word : allWords) {
            currentWord = word;
            checkForConcatenation(word);
        }
        concatenatedWords.sort(Comparator.comparing(String::length).reversed());
    }

    /**
     * Method that reads file line by line and each line inserts into Trie.
     * @param path - path to the file.
     * @throws IOException
     */
    public void readFileToTrie(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(word -> {
                allWords.add(word);
                trie.insert(word);
            });
        } catch (Exception e) {
            System.out.println("Problem occurred while reading your file : " + e);
        }
    }
}
