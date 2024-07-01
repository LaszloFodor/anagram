package service;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramServiceImpl implements AnagramService {
    private final Map<String, Set<String>> anagramMap = new HashMap<>();

    @Override
    public boolean areAnagrams(String text1, String text2) {
        return normalize(text1).equals(normalize(text2));
    }

    @Override
    public void addToAnagramMap(String text1, String text2) {
        String normalizedText1 = normalize(text1);
        String normalizedText2 = normalize(text2);

        anagramMap.putIfAbsent(normalizedText1, new HashSet<>());
        if (!anagramMap.get(normalizedText1).contains(text2))
            anagramMap.get(normalizedText1).add(text2);

        anagramMap.putIfAbsent(normalizedText2, new HashSet<>());
        if (!anagramMap.get(normalizedText2).contains(text1))
            anagramMap.get(normalizedText2).add(text1);
    }

    @Override
    public Set<String> getAnagrams(String text) {
        String normalizedText = normalize(text);
        Set<String> anagramSet = anagramMap.getOrDefault(normalizedText, new HashSet<>());
        return anagramSet.stream().filter(word -> !text.equals(word)).collect(Collectors.toSet());
    }

    private String normalize(String text) {
        char[] charArray = text.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

