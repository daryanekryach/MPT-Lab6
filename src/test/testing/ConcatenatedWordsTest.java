package testing;

import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

import java.io.IOException;

public class ConcatenatedWordsTest {
    private ConcatenatedWordsWithTrie concatenationTrie;

    @Before
    public void init() throws Exception {
        concatenationTrie = new ConcatenatedWordsWithTrie();
        concatenationTrie.readFileToTrie("D:\\DARYA\\GitHub\\MPT-Lab6\\test.txt");
        concatenationTrie.findConcatenatedWords();
    }

    @Test
    public void findConcatenatedWordsTrieTest() throws IOException {
        String check = "ratcatdogcat";
        assertEquals(concatenationTrie.concatenatedWords.get(0), check);
    }

    @Test
    public void freeTrieTest() {
        concatenationTrie.free();
        assertNull(concatenationTrie.concatenatedWords);
    }

    @Test
    public void checkForConcatenationTrieTest() {

    }

    @Test
    public void getFirstLongestConcatenatedWordTest() {
        String check = "ratcatdogcat";
        assertEquals(concatenationTrie.getFirstLongestConcatenatedWord(), check);
    }

    @Test
    public void getSecondLongestConcatenatedWordTest() {
        String check = "catsdogcats";
        assertEquals(concatenationTrie.getSecondLongestConcatenatedWord(), check);
    }

    @Test
    public void getNumberOfConcatenatedWordsTest() {
        int check = 3;
        assertEquals(concatenationTrie.getNumberOfConcatenatedWords(), check);
    }
}
