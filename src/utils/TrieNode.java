package utils;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-24
 */
public class TrieNode {
    int count;
    int prefix;
    TrieNode[] trieNodes = new TrieNode[26];

    public TrieNode() {
        count = 0;
        prefix = 0;
    }

    public TrieNode(int count, int prefix) {
        this.count = count;
        this.prefix = prefix;
    }
}
