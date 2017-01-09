package ua.edu.ucu.tries;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class RWayTrie implements Trie {
    private Node root; // root of trie

    public RWayTrie() {
        this.root = new Node();
    }

    @Override
    public void add(Tuple t) {
        put(t);
    }

    public Integer get(String key)
    {
        Node x = root.get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    public void put(Tuple t) {
        root = root.put(root, t.getTerm(), t.getWeight(), 0);
    }

    @Override
    public boolean contains(String word) {
        return get(word) == null && get(word) == word.length();
    }


    @Override
    public boolean delete(String word) {
        return root.put(root, word, 0, 0).val == 0;
    }

    @Override
    public Iterable<String> words() {
        ArrayList<String> itr = new ArrayList<>();
        root.DFS(root,"",itr);
        return itr;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        ArrayList<String> words = new ArrayList<>();
        root.DFS(root.get(root,s,0),s,words);
        return words;
    }

    @Override
    public int size() {
        ArrayList<String> words = new ArrayList<>();
        root.DFS(root,"",words);
        return words.size();
    }

}
