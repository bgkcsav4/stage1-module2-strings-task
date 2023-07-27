package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex;

        while (startIndex < source.length()) {
            endIndex = findNextDelimiter(source, startIndex, delimiters);

            String substring = source.substring(startIndex, endIndex);
            result.add(substring);
            startIndex = endIndex + 1;
        }

        return result;
    }

    private int findNextDelimiter(String source, int startIndex, Collection<String> delimiters) {
        int minIndex = source.length();
        for (String delimiter : delimiters) {
            int index = source.indexOf(delimiter, startIndex);
            if (index != -1 && index < minIndex) {
                minIndex = index;
            }
        }
        return minIndex;
    }
}