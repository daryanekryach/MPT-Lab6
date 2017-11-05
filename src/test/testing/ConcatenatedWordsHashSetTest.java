package testing;

import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

public class ConcatenatedWordsHashSetTest {
    private ConcatenatedWordsWithHashSet concatenationHashSet;

    @Before
    public void init() throws Exception {
        concatenationHashSet = new ConcatenatedWordsWithHashSet();
        concatenationHashSet.readFileToHashSet("test.txt");
        concatenationHashSet.findConcatenatedWords();
    }

    @Test
    public void findConcatenatedWordsHashSetTest() {
        String check = "ratcatdogcat";
        assertEquals(concatenationHashSet.concatenatedWords.get(0), check);
    }

    @Test
    public void freeHashSetTest() {
        concatenationHashSet.free();
        assertNull(concatenationHashSet.concatenatedWords);
    }

//    @Test
//    public void checkForConcatenationHashSetTest() {
//
//    }
}
