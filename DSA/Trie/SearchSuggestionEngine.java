import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Time:

Building Trie: O(N * L) where N is product count, L is max length.

For each prefix: DFS max 3 suggestions from sorted trie → O(3 * log σ) per level.

Total: O(N * L + W * 3) where W = length of searchWord.

Space:

Trie: O(N * L)

Result list: up to W * 3 entries.
*/
public class SearchSuggestionEngine {


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWordEnd;
        String word;
    }

    public void insert(TrieNode node, String word) {
        for(char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k-> new TrieNode());
        }
        node.isWordEnd=true;
        node.word=word;
    }

    public void dfs(TrieNode node, List<String> res) {
        if(node == null || res.size()>=3) return;
        if(node.isWordEnd) res.add(node.word);

        for(char c : node.children.keySet()) {
            dfs(node.children.get(c), res);
            if(res.size()==3) break;;
        }
    }

    public List<List<String>> searchEngine (List<String> products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for(char c : searchWord.toCharArray()) {
            node = node != null ? node.children.get(c) : null;
            List<String> suggestion = new ArrayList<>();
            dfs(node, suggestion);
            result.add(suggestion);
        }
        return result;
    }

    public static void main(String[] args) {
        SearchSuggestionEngine engine = new SearchSuggestionEngine();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        List<List<String>> suggestions = engine.searchEngine(List.of(products), "mouse");
        for (List<String> list : suggestions) {
            System.out.println(list);
        }
    }
}
