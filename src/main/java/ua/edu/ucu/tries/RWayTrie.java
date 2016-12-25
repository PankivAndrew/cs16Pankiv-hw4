package ua.edu.ucu.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class RWayTrie implements Trie {
    ArrayList<Tuple> list = new ArrayList();

    @Override
    public void add(Tuple t) {
        list.add(t);
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
        throw new UnsupportedOperationException("Not supported yet.");
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
