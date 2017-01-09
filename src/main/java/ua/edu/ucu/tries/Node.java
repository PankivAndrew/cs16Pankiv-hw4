package ua.edu.ucu.tries;

import java.util.ArrayList;

/**
 * Created by Andrue on 07.01.2017.
 */
class Node {
    private static int R = 26;
    private static int FirstLetter = 97;
    public Integer val;
    public Node[] next = new Node[R];
    public Node parent;

    public Node get(Node x, String key, int d) { // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c-FirstLetter], key, d + 1);
    }
    public Node put(Node x, String key, Integer val, int d)
    { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c - FirstLetter] = put(x.next[c - FirstLetter], key, val, d+1);
        return x;
    }
    protected void DFS(Node x, String tmpWord, ArrayList<String> resList) {
        if (x != null) {
            if (x.getVal() != null && x.getVal() > 0) resList.add(tmpWord);
            for (int i = 0; i < R; i++) {
                DFS(x.next[i], tmpWord + (char) (i+FirstLetter), resList);
            }
        }
    }

    public Integer getVal() {
        return val;
    }
}
