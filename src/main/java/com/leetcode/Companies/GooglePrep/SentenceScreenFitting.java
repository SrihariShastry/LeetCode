package com.leetcode.Companies.GooglePrep;

public class SentenceScreenFitting {
    /**
     * First we form the complete sentence by using the Join API of String Class
     * we start our index from 0; for every row, we add column number of characters
     * we then check if character at start % l is a space. if it is then we continue our search
     * otherwise, we go back until we find a space(to enable us to only have full words in a line
     * since we cannot have words split into halves)
     * <p>
     * Since we do not count half sentences, we can directly
     * return start/l (number of characters printed / length of the complete sentence)
     * <p>
     * Start only contains count of characters and necessary spaces and not the extra spaces
     * we add as padding
     *
     * @param sentence List of words
     * @param rows     number of rows in the screen
     * @param cols     number of cols in the screen
     * @return return the number of times we can repeat the sentence within the string
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int l = s.length();
        int start = 0;
        for (int row = 0; row < rows; row++) {
            start += cols;
            if (s.charAt(start % l) == ' ') start++;
            else
                while (start > 0 && s.charAt((start - 1) % l) != ' ') start--;
        }
        return start / l;
    }
}
