package ua.edu.ucu.tries;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class RWayTrie implements Trie {
    ArrayList<Tuple> list = new ArrayList();
    private static int R = 26; // radix
    private Node root; // root of trie

    @Override
    public void add(Tuple t) {
        list.add(t);
    }
//    public Tuple get(int i){
//        return list.get(i);
//    }

    public Object get(String key)
    {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return  x.val;
    }
    private Node get(Node x, String key, int d)
    { // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }
    public void put(Tuple t)
    { root = put(root, t.getTerm(), t.getWeight(), 0); }
    private Node put(Node x, String key, Object val, int d)
    { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }




    @Override
    public boolean contains(String word) {
        for(int i = 0; i < size();i++){
            if(list.get(i).getTerm().equals(word)){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean delete(String word) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).getTerm().equals(word)) {
                list.remove(word);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<String> words() {
        Iterable<String> itr = new Iterable<String>() {
            @Override
             public Iterator<String> iterator() {
                return null;
            }
        };
        return itr;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        String[] arr = new String[size()];
        int index = 0;
        for (int i = 0; i < size();i++){
            if(Objects.equals(list.get(i).getTerm().substring(0, s.length()), s)){
                arr[index] = list.get(i).getTerm();
                index++;
            }
        }
        Iterable<String> itr = Arrays.asList(arr);
        return itr;
    }

    @Override
    public int size() {
        return list.size();
    }

}
