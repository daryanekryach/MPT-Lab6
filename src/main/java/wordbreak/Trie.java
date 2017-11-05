package wordbreak;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

     void insert(String word) {
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
    }

     boolean isPresentInTrie(String word) {
        TrieNode node = searchNode(word);
        if (node == null) {
            return false;
        } else {
            if (node.isEnd)
                return true;
        }
        return false;
    }

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

        if (node == root)
            return null;

        return node;
    }
}
