package Algorithm.dataStructure.Trie前缀树;

/**
 * @Author: YHQ
 * @Date: 2019/12/15 13:25
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        if (word == null||word.length() == 0) return;
        TrieNode node = root;
        TrieNode temp = null;
        for (int i=0,len = word.length();i<len;i++){
            Character c = word.charAt(i);
            temp = node.content.get(c);
            if (temp==null){
                temp = new TrieNode();
                node.content.put(c,temp);
            }
            node = temp;
        }
        node.isLeaf = true;
    }

    public boolean search(String word){
        if (word==null||word.length()==0) return false;
        TrieNode node = root;
        TrieNode temp = null;
        for (int i=0,len = word.length();i<len;i++){
            Character c = word.charAt(i);
            temp = node.content.get(c);
            if (temp == null){
                return false;
            }
            node = temp;
        }
        return node.isLeaf;
    }
    public boolean startWith(String prefix){
        if (prefix == null || prefix.length()==0)
            return false;
        TrieNode node = root;
        TrieNode temp = null;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            temp = node.content.get(c);
            if (temp == null)
                return false;
            node = temp;
        }
        return true;
    }
    public static void main(String args[]){
        Trie t = new Trie();
        t.insert("apple");
        t.insert("application");
        t.insert("play");
    }
}
