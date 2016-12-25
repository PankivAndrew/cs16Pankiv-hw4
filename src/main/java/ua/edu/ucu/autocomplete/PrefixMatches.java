package ua.edu.ucu.autocomplete;

import sun.management.counter.Units;
import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {


    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = new RWayTrie();
    }
    public boolean isLine(String string){
        Boolean isline = false;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == ' '){
                isline = true;
                break;
            }
        }
        return isline;
    }
    public boolean isLine(String[] arr){
        return false;
    }
    public String convertArrayToString(String... strings){
        return String.valueOf(strings);
    }

    public int load(String... strings) {
        if (ArrayList.class.equals(strings.getClass())){
            ;
        }
        else if (isLine(strings)){
            String str = convertArrayToString(strings);
            str.split(" ");
        }
        for (String i : strings){
            if (i.length() >= 2){
                trie.add(new Tuple(i,i.length()));
            }
        }
        return 0;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public int size() {
        return trie.size();
    }


}
