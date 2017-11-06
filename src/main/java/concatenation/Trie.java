package concatenation;

/**
 * Class that implements Trie data structure.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Method that inserts word into trie.
     * @param word - original words.
     * @return
     */
    public boolean insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.letters[index] == null) {
                TrieNode temp = new TrieNode();
                node.letters[index] = temp;
                node = temp;
            } else
                node = node.letters[index];
        }
        node.isEnd = true;
        return node.isEnd;
    }

    /**
     * Method that checks if the word is present in the Trie
     * @param word - word to look for in trie.
     * @return
     */
    public boolean isPresentInTrie(String word) {
        TrieNode node = searchNode(word);
        if (node == null) {
            return false;
        } else {
            if (node.isEnd)
                return true;
        }
        return false;
    }

    /**
     * Mwthod that performes searching for the node, that contains word.
     * @param word - word to search.
     * @return
     */
    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.letters[index] != null) {
                node = node.letters[index];
            } else
                return null;
        }

        if (node.equals(root))
            return null;

        return node;
    }
}
