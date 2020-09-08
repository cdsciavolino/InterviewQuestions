import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionsSP20Test {
    @Test
    void testMaxProfit() {
        assertEquals(9, SolutionsSP20.maxProfit(new int[]{3, 1, 5, 10, 2}));
        assertEquals(0, SolutionsSP20.maxProfit(new int[]{5, 4, 3, 2}));
        assertEquals(6, SolutionsSP20.maxProfit(new int[]{1, 2, 3, 5, 7}));
        assertEquals(45, SolutionsSP20.maxProfit(new int[]{5, 50, 1, 8}));
    }

    @Test
    void testOceanView() {
        assertEquals(3, SolutionsSP20.oceanView(new int[]{7, 6, 5, 5}));
        assertEquals(1, SolutionsSP20.oceanView(new int[]{5, 6, 7, 8}));
        assertEquals(5, SolutionsSP20.oceanView(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void testKNearestRestaurants() {
        SolutionsSP20.Coordinate rest1 = new SolutionsSP20.Coordinate(1, 1);
        SolutionsSP20.Coordinate rest2 = new SolutionsSP20.Coordinate(2, 0);
        SolutionsSP20.Coordinate rest3 = new SolutionsSP20.Coordinate(3, 4);
        SolutionsSP20.Coordinate rest4 = new SolutionsSP20.Coordinate(-1, 0);
        SolutionsSP20.Coordinate home = new SolutionsSP20.Coordinate(0, 0);
        SolutionsSP20.Coordinate[] computed = SolutionsSP20.kNearestRestaurants(
                new SolutionsSP20.Coordinate[] { rest1, rest2, rest3, rest4},
                home,
                1
        );

        assertEquals("(-1, 0)", computed[0].toString());
    }

    @Test
    void testKMostFrequentWords() {
        String corpus = "the cat sat on the red fluffy carpet with another cat and the third fluffy cat joined the others";
        String[] omit = new String[]{ "a", "on", "the", "with" };
        String[] computed = SolutionsSP20.kMostFrequentWords(corpus, omit, 2);
        assertEquals("cat", computed[0]);
        assertEquals("fluffy", computed[1]);
    }

    @Test
    void testNumIslands() {
        int[][] example = {
                { 1, 1, 0, 0, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
        };
        assertEquals(3, SolutionsSP20.numIslands(example));
    }

    @Test
    void testMinWordTransform() {
        List<String> wordList = new ArrayList<String>();
        Collections.addAll(wordList, "hot","dot","dog","lot","log","cog");
        assertEquals(5, SolutionsSP20.minWordTransform("hit", "cog", wordList));

        wordList.remove("cog");
        assertEquals(0, SolutionsSP20.minWordTransform("hit", "cog", wordList));
        assertEquals(2, SolutionsSP20.minWordTransform("hit", "hot", wordList));
        assertEquals(0, SolutionsSP20.minWordTransform("cog", "hit", wordList));
    }

    @Test
    void testLRUCache() {
        SolutionsSP20.LRUCache cache = new SolutionsSP20.LRUCache(2);
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));
        cache.put(3, 3);
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(-1, cache.get(1));
        cache.put(4, 4);
        assertEquals(-1, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(4, cache.get(4));
        cache.put(4, 5);
        assertEquals(5, cache.get(4));
    }
}
