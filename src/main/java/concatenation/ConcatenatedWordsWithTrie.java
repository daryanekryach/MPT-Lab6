package concatenation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class ConcatenatedWordsWithTrie extends ConcatenatedWords {
    private Trie trie;
    private ArrayList<String> allWords;

    public ConcatenatedWordsWithTrie() {
        trie = new Trie();
        allWords = new ArrayList<>();
    }

    public void free() {
        trie = null;
        concatenatedWords = null;
        allWords = null;
    }

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

    public void findConcatenatedWords() {
        for (String word : allWords) {
            currentWord = word;
            checkForConcatenation(word);
        }
        concatenatedWords.sort(Comparator.comparing(String::length).reversed());
    }

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
