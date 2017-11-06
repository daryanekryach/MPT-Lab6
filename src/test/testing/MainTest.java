package testing;

import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

import java.io.IOException;

public class MainTest {

    @Test
    public void hashSetImplementationTest() throws IOException {
        assertTrue(Main.hashSetImplementation());
    }

    @Test
    public void trieImplementationTest() throws IOException {
        assertTrue(Main.trieImplementation());
    }
}
