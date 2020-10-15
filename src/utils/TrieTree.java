package utils;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-24
 */
public class TrieTree {
    TrieNode root;
    int level;

    public TrieTree() {
        root = new TrieNode();
        level = 0;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public int getLevel() {
        return level;
    }

    public void put(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        putHelp(word, root);
    }

    private void putHelp(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            if (root.trieNodes[word.charAt(i) - 'a'] == null) {
                root.trieNodes[word.charAt(i) - 'a'] = new TrieNode();
                root = root.trieNodes[word.charAt(i) - 'a'];
                root.prefix++;
            }
        }
        root.count++;
        level = Math.max(level, word.length());
    }

    public int search(String word) {
        if (word == null || word.isEmpty()) {
            return -1;
        }
        return searchHelp(word, root);
    }

    private int searchHelp(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            TrieNode trieNode = root.trieNodes[word.charAt(i) - 'a'];
            if (trieNode == null) {
                return -1;
            }
            root = trieNode;
        }
        return root.count;
    }

    public int searchPrefix(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return -1;
        }
        return searchPrefixHelp(prefix, root);
    }

    private int searchPrefixHelp(String prefix, TrieNode root) {
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode trieNode = root.trieNodes[prefix.charAt(i) - 'a'];
            if (trieNode == null) {
                return -1;
            }
            root = trieNode;
        }
        return root.prefix;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.put("abc");
        System.out.println(trieTree.searchPrefix("a"));
    }
}
