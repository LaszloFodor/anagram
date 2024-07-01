package service;

import java.util.Set;

public interface AnagramService {
    boolean areAnagrams(String text1, String text2);
    void addToAnagramMap(String text1, String text2);
    Set<String> getAnagrams(String text);
}
