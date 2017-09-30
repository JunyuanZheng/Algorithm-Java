import java.util.HashMap;

public class Question208ImplementTrie {
    class TireNode {
        HashMap<Character, TireNode> map = new HashMap<>();
        char value;
        boolean isLeaf;

        TireNode() {

        }

        TireNode(char c) {
            this.value = c;
        }
    }

    class Trie {

        TireNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TireNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TireNode tireNode = this.root;
            for (int i = 0; i < word.length(); i += 1) {
                char c = word.charAt(i);
                if (tireNode.map.containsKey(c)) {
                    tireNode = tireNode.map.get(c);
                } else {
                    TireNode tmp = new TireNode(c);
                    tireNode.map.put(c, tmp);
                    tireNode = tmp;
                }
                if (i == word.length() - 1) {
                    tireNode.isLeaf = true;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TireNode tireNode = this.root;
            for (int i = 0; i < word.length(); i += 1) {
                char c = word.charAt(i);
                if (tireNode.map.containsKey(c)) {
                    tireNode = tireNode.map.get(c);
                } else {
                    return false;
                }
                if (i == word.length() - 1 && !tireNode.isLeaf) {
                    return false;
                }
            }
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TireNode tireNode = this.root;
            for (int i = 0; i < prefix.length(); i += 1) {
                char c = prefix.charAt(i);
                if (tireNode.map.containsKey(c)) {
                    tireNode = tireNode.map.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}