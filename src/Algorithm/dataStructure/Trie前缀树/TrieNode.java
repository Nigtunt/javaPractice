package Algorithm.dataStructure.Trie前缀树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YHQ
 * @Date: 2019/12/15 13:28
 */
public class TrieNode {
    boolean isLeaf;
    Map<Character,TrieNode> content;
    // Initialize your data structure here.
    public TrieNode() {
        content = new HashMap<Character,TrieNode>();
    }
}
