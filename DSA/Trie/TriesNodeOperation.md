✅ Problem Summary
Implement a Trie class with:

- insert(word)
- search(word)
- startsWith(prefix)

✅ Operation Complexity
- insert(word) → O(L)
- search(word) → O(L)
- startsWith(prefix) → O(L)


✅ Java Implementation
```java
/*
*Time Complexity
*
insert(word) → O(L)
search(word) → O(L)
startsWith(prefix) → O(L)
*
Where L = length of the word or prefix
*/

public class TrieNodeOperations {

    static class Trie {
        static class TrieNode {
            TrieNode[] children;
            boolean isWordEnded;

            TrieNode() {
                children=new TrieNode[26];
                isWordEnded = false;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if (node.children[c-'a']==null) node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.isWordEnded=true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if (node.children[c-'a'] == null) return false;
                node = node.children[c-'a'];
            }
            return node.isWordEnded;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char c : prefix.toCharArray()) {
                if(node.children[c-'a'] == null) return false;
                node = node.children[c-'a'];
            }
            return node!=null;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("banana");
        System.out.println("Search for apple: "+ trie.search("apple"));
        System.out.println("Start with ban: "+ trie.startsWith("ban"));
        System.out.println("Search for app: "+ trie.search("app"));
        trie.insert("app");
        System.out.println("Search for app: "+ trie.search("app"));
    }
}
```
