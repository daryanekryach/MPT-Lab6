package concatenation;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        trieImplementation();
        hashSetImplementation();
    }

    /**
     * Reading file, searching for concatenated words, measuring metrics
     * for Trie implementation.
     * @return
     * @throws IOException
     */
    public static boolean trieImplementation() throws IOException {
        System.out.println("FINDING CONCATENATED WORDS WITH TRIE IMPLEMENTATION\n");

        ConcatenatedWordsWithTrie concatenationTrie = new ConcatenatedWordsWithTrie();
        concatenationTrie.readFileToTrie("words.txt");
        Metrics.start();
        concatenationTrie.findConcatenatedWords();
        Metrics.stop();
        Metrics.getAllMetrics();
        getConcatenatedWordsInfo(concatenationTrie);
        concatenationTrie.free();
        return true;
    }

    /**
     * Reading file, searching for concatenated words, measuring metrics
     * for HashSet implementation.
     * @return
     * @throws IOException
     */
    public static boolean hashSetImplementation() throws IOException {
        System.out.println("\nFINDING CONCATENATED WORDS WITH HASHSET IMPLEMENTATION\n");

        ConcatenatedWordsWithHashSet concatenationHashSet = new ConcatenatedWordsWithHashSet();
        concatenationHashSet.readFileToHashSet("words.txt");
        Metrics.start();
        concatenationHashSet.findConcatenatedWords();
        Metrics.stop();
        Metrics.getAllMetrics();
        getConcatenatedWordsInfo(concatenationHashSet);
        concatenationHashSet.free();
        return true;
    }

    /**
     * Prints the longest, the second longest concatenated words and the
     * number of concatenated words.
     * @param concatenation - instance of ConcatenatedWords with particular
     *                      implementation.
     */
    private static void getConcatenatedWordsInfo(ConcatenatedWords concatenation) {
        System.out.println("The first longest concatenated word is " +
                concatenation.getFirstLongestConcatenatedWord());
        System.out.println("The second longest concatenated word is " +
                concatenation.getSecondLongestConcatenatedWord());
        System.out.println("The number of concatenated words is " +
                concatenation.getNumberOfConcatenatedWords());
    }
}
