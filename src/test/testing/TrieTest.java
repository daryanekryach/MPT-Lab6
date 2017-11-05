package testing;

import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

public class TrieTest {
    private Trie trie;

    @Before
    public void init() {
        trie = new Trie();
    }

    @Test
    public void trieInsertTest() throws NoSuchFieldException, IllegalAccessException {
        String check = "horse";
        assertTrue(trie.insert(check));
    }

    @Test
    public void trieIsPresentTest() {
        String check = "horse";
        trie.insert(check);
        assertTrue(trie.isPresentInTrie(check));
    }
}
