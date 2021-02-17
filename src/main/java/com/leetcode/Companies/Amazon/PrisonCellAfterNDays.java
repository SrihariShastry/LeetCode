package com.leetcode.Companies.Amazon;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellAfterNDays {
    /**
     * Idea is to recognize the repeat pattern. Since the number of cells are fixed to 8
     * and since the first and the last cells are going to stay 0,
     * we can say that there are 2^6 different combinations for cell values
     * <p>
     * Basically we store the Cell values on a hashmap and produce first N variations.
     * Once we find a repetition, we can safely mod the N value by
     * lastFoundRepetitionN - currentN to avoid going through the same steps again
     * What this does is, it lowers the number of days we have to process
     * <p>
     * finally we return the final state of the cells
     *
     * @param cells Initial cell values
     * @param N     Number of days
     * @return the cell condition after N days
     */
    public int[] prisonAfterNDays(int[] cells, int N) {

        HashMap<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i + 1] == cells[i - 1] ? 1 : 0;
            }
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells)))
                N %= seen.get(Arrays.toString(cells)) - N;
        }

        return cells;
    }
}
