package ua.edu.ucu.autocomplete;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


/**
 *
 * @author andrii
 */
public class PrefixMatches {


    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
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
        int length = 0;
        int index = 0;
        int check = 0;
        String[] prefList = new String[length(trie.wordsWithPrefix(pref))];
        for (String element : trie.wordsWithPrefix(pref)) {
            prefList[index] = element;
            index++;
        }
        index = 0;
        Arrays.sort(prefList, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        for(String element : prefList){
            if(length < element.length()){
                check++;
            }
            if(check - 1 == k){
                break;
            }
            index++;
            length = element.length();
        }
        String[] arr = new String[index];
        index = 0;
        length = 0;
        check = 0;
        for(String element : prefList){
            if(length < element.length()){
                check++;
            }
            if(check - 1 == k){
                break;
            }
            arr[index] = element;
            index++;
            length = element.length();
        }
        Iterable<String> itr = Arrays.asList(arr);
        return itr;
    }
    public int length(Iterable<String> pref){
        int size = 0;
        for(String value : pref) {
            size++;
        }
        return size;
    }

    public int size() {
        return trie.size();

    }



}
