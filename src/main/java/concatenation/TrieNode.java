package concatenation;

public class TrieNode {
    public TrieNode[] letters;
    public boolean isEnd;

    public TrieNode() {
        this.letters = new TrieNode[26];
    }
}
