import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SolutionsFA19Test {
    @Test
    void testAreAnagrams() {
        assertTrue(SolutionsFA19.areAnagrams("abcd", "cbad"));
        assertTrue(SolutionsFA19.areAnagrams("night", "thing"));
        assertTrue(SolutionsFA19.areAnagrams("save", "vase"));
        assertTrue(SolutionsFA19.areAnagrams("", ""));
        assertTrue(SolutionsFA19.areAnagrams("swims", "swims"));

        assertFalse(SolutionsFA19.areAnagrams("notthesamesize", "notthesamesiz"));
        assertFalse(SolutionsFA19.areAnagrams("onediffletter", "onedifflettes"));
        assertFalse(SolutionsFA19.areAnagrams("saves", "savess"));
        assertFalse(SolutionsFA19.areAnagrams("savse", "savee"));
    }

    @Test
    void testValidParentheses() {
        assertTrue(SolutionsFA19.isValidParentheses("()"));
        assertTrue(SolutionsFA19.isValidParentheses("[]"));
        assertTrue(SolutionsFA19.isValidParentheses("{}"));
        assertTrue(SolutionsFA19.isValidParentheses("()[]{}"));
        assertTrue(SolutionsFA19.isValidParentheses("([{}])"));

        assertFalse(SolutionsFA19.isValidParentheses("(]"));
        assertFalse(SolutionsFA19.isValidParentheses("([)]"));
        assertFalse(SolutionsFA19.isValidParentheses("())"));
        assertFalse(SolutionsFA19.isValidParentheses("((()()()())"));
    }

    @Test
    void testAbsoluteFilePath() {
        assertEquals("", SolutionsFA19.simplifyFilePath(""));
        assertEquals("/", SolutionsFA19.simplifyFilePath("/../"));
        assertEquals("/home/foo", SolutionsFA19.simplifyFilePath("/home//foo/"));
        assertEquals("/c", SolutionsFA19.simplifyFilePath("/a/./b/../../c/"));
        assertEquals("/c", SolutionsFA19.simplifyFilePath("/a/./b/../../c/"));
        assertEquals("/a/b/c", SolutionsFA19.simplifyFilePath("/a//b////c/d//././/.."));
        assertEquals(
                "/home/chris/documents/cos226",
                SolutionsFA19.simplifyFilePath("/home/chris/desktop/.././/documents/cos226/"));
    }

    @Test
    void testMinWordTransform() {
        List<String> wordList = new ArrayList<String>();
        Collections.addAll(wordList, "hot","dot","dog","lot","log","cog");
        assertEquals(5, SolutionsFA19.minWordTransform("hit", "cog", wordList));

        wordList.remove("cog");
        assertEquals(0, SolutionsFA19.minWordTransform("hit", "cog", wordList));
        assertEquals(2, SolutionsFA19.minWordTransform("hit", "hot", wordList));
        assertEquals(0, SolutionsFA19.minWordTransform("cog", "hit", wordList));
    }

    @Test
    void testCheapestFlightsWithLayovers() {
        int numCities = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        assertEquals(200, SolutionsFA19.cheapestFlightsWithLayovers(numCities, flights, 0, 2, 1));
        assertEquals(500, SolutionsFA19.cheapestFlightsWithLayovers(numCities, flights, 0, 2, 0));

        numCities = 4;
        flights = new int[][] {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1},
                {0, 2, 5},
        };
        assertEquals(3, SolutionsFA19.cheapestFlightsWithLayovers(numCities, flights, 0, 3, 2));
        assertEquals(6, SolutionsFA19.cheapestFlightsWithLayovers(numCities, flights, 0, 3, 1));
    }

    @Test
    void testLRUCache() {
        SolutionsFA19.LRUCache cache = new SolutionsFA19.LRUCache(2);
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
