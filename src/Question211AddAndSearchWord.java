import java.util.HashMap;

class TireNode {
    boolean isLeaf;
    HashMap<Character, TireNode> map = new HashMap<>();
}

class WordDictionary {
    private TireNode root = new TireNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TireNode tireNode = this.root;
        for (int i = 0; i < word.length(); i += 1) {
            char c = word.charAt(i);
            if (tireNode.map.containsKey(c)) {
                tireNode = tireNode.map.get(c);
            } else {
                TireNode tmp = new TireNode();
                tireNode.map.put(c, tmp);
                tireNode = tmp;
            }

            if (i == word.length() - 1) {
                tireNode.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        return helper(word, this.root, 0);
    }

    private boolean helper(String word, TireNode tireNode, int index) {
        if (index == word.length())
            return tireNode.isLeaf;
        char c = word.charAt(index);
        if (c == '.') {
            for (TireNode t : tireNode.map.values()) {
                if (helper(word, t, index + 1))
                    return true;
            }
        } else {
            if (!tireNode.map.containsKey(c)) {
                return false;
            } else {
                if (helper(word, tireNode.map.get(c), index + 1))
                    return true;
            }
        }
        return false;
    }
}

public class Question211AddAndSearchWord {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        // wordDictionary.addWord("a");
        // System.out.println(wordDictionary.search("."));
    }
}
