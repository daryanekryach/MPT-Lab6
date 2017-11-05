package wordbreak;

public class TrieNode {
    TrieNode[] letters;
    boolean isEnd;

    TrieNode() {
        this.letters = new TrieNode[26];
    }
}
