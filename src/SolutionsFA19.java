import java.util.*;
public class SolutionsFA19 {
    /**
     * Returns true iff the characters in word1 can be rearranged to form word2 (i.e.
     * if they are anagrams of each other). False otherwise.
     *
     * Leetcode Reference: https://leetcode.com/problems/valid-anagram/
     *
     * Time: O(n) where n is the max(word1.length(), word2.length())
     * Space: O(c) where c is the number of distinct characters possible
     *
     * @param word1 First word
     * @param word2 Second word
     * @return True or false whether they are anagrams of each other
     */
    static boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Count all the distinct characters in word1
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        for (char c : word1.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Check for unseen characters and unavailable characters
        for (char c : word2.toCharArray()) {
            if (!charCounts.containsKey(c)) return false;
            if (charCounts.get(c) == 0) return false;
            charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
        }
        return true;
    }

    /**
     * Returns true iff the string `parens` contains a valid series of parentheses (),
     * brackets [], and braces {}. False otherwise.
     *
     *  - Opening brackets must be closed by the same type of bracket
     *  - Opening brackets must be closed in the correct order
     *
     * Leetcode Reference: https://leetcode.com/problems/valid-parentheses/
     *
     * Time: O(n) where n is the length of the input string `parens`
     * Space: O(n) where n is the length of the input string `parens`
     *
     * @param parens string sequence of (, ), [, ], {, } characters
     * @return true or false if the sequence is valid
     */
    static boolean isValidParentheses(String parens) {
        // Create mapping from closing character -> opening character
        Map<Character, Character> matches = new HashMap<Character, Character>();
        matches.put(')', '(');
        matches.put(']', '[');
        matches.put('}', '{');

        // Check for corresponding characters in the string
        Stack<Character> seen = new Stack<Character>();
        for (char c : parens.toCharArray()) {
            if (!matches.containsKey(c)) seen.push(c);              // it's an opening character, push it to `seen`
            else if (seen.isEmpty()) return false;                  // no matching opening character
            else if (matches.get(c) != seen.pop()) return false;    // incorrect matching opening character
        }

        // check no unmatched opening character
        return seen.isEmpty();
    }

    /**
     * Given an absolute path for a file (Unix-style), simplify it to the
     * shortest possible absolute path to the same directory.
     *
     * Formal Constraints & Definitions
     *  - the `.` sequence means stay in the current directory
     *  - the `..` sequence means move up a directory
     *  - the `//` sequence can be interpreted to be `/./`
     *  - the final return string must begin with a `/` character
     *  - you cannot move up further than the root directory
     *
     * Leetcode Reference: https://leetcode.com/problems/simplify-path/
     *
     * Time: O(n) where n is the number of `/` separated operations in input `path`
     * Space: O(n) where n is the number of `/` separated operations in input `path`
     *
     * @param path Absolute path to convert
     * @return The shortest absolute path denoted by the input string `path`
     */
    static String simplifyFilePath(String path) {
        if (path == null || "".equals(path)) return path;

        // Break the original filepath into operations and simulate each operation
        String[] pathOps = path.split("/");
        Stack<String> curPath = new Stack<String>();
        for (int i = 1; i < pathOps.length; i++) {
            String op = pathOps[i];

            // if `//` or `/./`, then do nothing
            if (!op.equals("") && !op.equals(".")) {
                if (op.equals("..")) {
                    // `..` -> move up a directory if we're not in the root directory
                    if (!curPath.isEmpty()) curPath.pop();
                } else {
                    // `desktop` -> move down to `op` directory
                    curPath.push(op);
                }
            }
        }

        // Convert the stack into a `/` separated string and prepend first `/`
        return "/" + String.join("/", curPath);
    }

    /**
     * Given two words `start` and `end` and a dictionary of all possible words `wordList`,
     * find the minimum number of operations to convert from `start` to `end` using only
     * words in `wordList`. Return 0 if no transformation is possible.
     *
     *  Leetcode reference: https://leetcode.com/problems/word-ladder/
     *
     *  Ex. wordList=[ "hot", "dot", "dog", "log", "cog" ]
     *  Input: start="hit", end="cog",
     *  Output: 5
     *  Explanation: hit -> hot -> dot -> dog -> cog
     *
     *  Notes:
     *      - Only 1 character can be changed at a time
     *      - Each transformed word must be in the given word list
     *
     *  n = wordList.length
     *  w = wordList[0].length()
     *  c = alphabet.size()
     *
     *  Time: O(nwc) to preprocess neighborWords map
     *  Space: O(n^2) when each word is a neighbor of every other word
     *
     * @param start beginning word
     * @param end ending word
     * @param wordList list of available transformation words
     * @return minimum number of operations to convert from start to end, or 0 if impossible
     */
    static int minWordTransform(String start, String end, List<String> wordList) {
        // Preprocess the wordList into a Set for fast .contains operations
        Set<String> words = new HashSet<String>(wordList);
        words.add(start);

        // Preprocess the words in the wordList into neighboring words
        // Map from word -> 1 character away neighboring words
        final int NUM_CHARACTERS = 26;
        final int WORD_LEN = start.length();
        Map<String, List<String>> neighborWords = new HashMap<String, List<String>>();
        for (String word : words) {
            List<String> neighbors = new ArrayList<String>();
            for (int ind = 0; ind < word.length(); ind++) {
                String prefix = word.substring(0, ind);
                String postfix = word.substring(ind+1, WORD_LEN);
                for (int i = 0; i < NUM_CHARACTERS; i++) {
                    char curChar = (char)('a' + i);
                    String neighbor = prefix + curChar + postfix;
                    if (words.contains(neighbor)) neighbors.add(neighbor);
                }
            }
            neighborWords.put(word, neighbors);
        }

        // BFS search for minimal sequences to end word
        Queue<WordNode> nextWords = new LinkedList<WordNode>();
        Set<String> visited = new HashSet<String>();
        nextWords.add(new WordNode(start, 1));
        visited.add(start);
        while (!nextWords.isEmpty()) {
            WordNode curWord = nextWords.poll();
            if (curWord.word.equals(end)) return curWord.numSteps;

            List<String> neighbors = neighborWords.get(curWord.word);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    nextWords.add(new WordNode(neighbor, curWord.numSteps + 1));
                    visited.add(neighbor);
                }
            }
        }

        return 0;
    }

    // Abstraction representing a (word, steps) tuple
    // Used for Word Ladder problem
    private static class WordNode {
        String word;
        int numSteps;

        WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    /**
     * Find the cost of the cheapest series of flights to get from `src` -> `dst` using at most
     * `maxLayovers` intermediate flights given:
     *      - `flights[][]` where flights[i] is in the form [from, to, flightPrice]
     *      - `numCities` is the number of cities on the map
     *      - `src` is the start city
     *      - `dst` is the destination city
     *      - `maxLayovers` is the maximum number of flights you can take to get from src -> dst
     *
     *  Leetcode reference: https://leetcode.com/problems/cheapest-flights-within-k-stops/
     *
     *  n = number of cities
     *  l = maxLayovers
     *  Time: O(n^l) to BFS through the n cities with l layovers maximum
     *  Space: O(n^l) to store a queue of flights in the case all cities can go to all other cities
     *
     *  @return the cost of the cheapest flight sequence
     */
    static int cheapestFlightsWithLayovers(int numCities, int[][] flights, int src, int dst, int maxLayovers) {
        // Preprocess `flights` into map of (from -> (to -> flightCost))
        Map<Integer, Map<Integer, Integer>> srcDstPrice = new HashMap<Integer, Map<Integer, Integer>>();
        for (int[] flight : flights) {
            // flight = [ from, to, price ]
            if (!srcDstPrice.containsKey(flight[0]))
                srcDstPrice.put(flight[0], new HashMap<Integer, Integer>());
            srcDstPrice.get(flight[0]).put(flight[1], flight[2]);
        }

        // Run BFS from `src` city to all other cities
        // Each entry in the Queue is in the form [ curCity, numLayovers, srcToCityPrice ]
        Queue<int[]> nextFlights = new LinkedList<int[]>();
        nextFlights.add(new int[]{src, 0, 0});
        int optCost = Integer.MAX_VALUE;
        while (!nextFlights.isEmpty()) {
            int[] curNode = nextFlights.poll();
            Map<Integer, Integer> outFlights = srcDstPrice.getOrDefault(curNode[0], new HashMap<>());
            for (Map.Entry<Integer, Integer> outFlight : outFlights.entrySet()) {
                int neighbor = outFlight.getKey();
                int totalCostToNeighbor = curNode[2] + outFlight.getValue();

                // if we found a better path to `dst`, update optCost
                if (neighbor == dst && optCost > totalCostToNeighbor)
                    optCost = totalCostToNeighbor;

                // if we're within the layover limit and haven't surpassed the best so far
                if (curNode[1] < maxLayovers && totalCostToNeighbor < optCost)
                    nextFlights.add(new int[]{neighbor, curNode[1] + 1, totalCostToNeighbor});
            }
        }

        return optCost != Integer.MAX_VALUE ? optCost : -1;
    }

    /**
     * Given a positive capacity, design an LRU cache that supports a get(key) operation and
     * a put(key, value) operation in constant time.
     *
     *  Leetcode Reference: https://leetcode.com/problems/lru-cache/
     *
     *  Solution uses:
     *      - HashMap from Key -> ListNode to store and retreive the key-value pairs quickly.
     *      - Doubly Linked List to keep track of the LRU ordering
     */
    static class LRUCache {
        int capacity;                   // max number of entries in the LRU cache
        Map<Integer, ListNode> cache;   // storage of the k,v pairs in the LRU cache
        ListNode lru;                   // pointer to the least-recently-used node (front)
        ListNode mru;                   // pointer to the most-recently-used node (back)

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<Integer, LRUCache.ListNode>();
        }

        /**
         * Returns the value associated with `key` in the LRU cache, or -1 if it's
         * not present.
         * @param key key of the LRU cache entry
         * @return value of the LRU cache entry, -1 if not present
         */
        public int get(int key) {
            if (cache.containsKey(key)) {
                ListNode found = cache.get(key);
                remove(found);
                addToEnd(found);
                return found.val;
            }
            return -1;
        }

        /**
         * Adds the (`key`, `value`) pair to the LRU cache, evicting the least-recently-used
         * entry if the cache is full.
         * @param key key of the LRU cache entry
         * @param value value of the LRU cache entry
         */
        public void put(int key, int value) {
            ListNode newNode = new ListNode(key, value, null, null);
            if (cache.containsKey(key)) {
                // just update value
                remove(cache.get(key));
                cache.put(key, newNode);
                addToEnd(newNode);
            }
            else if (cache.size() == capacity) {
                // evict lru element
                ListNode lruNode = lru;
                cache.remove(lruNode.key);
                remove(lruNode);
                cache.put(key, newNode);
                addToEnd(newNode);
            } else {
                // no need to evict
                cache.put(key, newNode);
                addToEnd(newNode);
            }
        }

        // Performs a remove-from-middle LinkedList operation
        private void remove(ListNode node) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            if (node.prev == null) lru = node.next;
            if (node.next == null) mru = node.prev;
            node.next = null;
            node.prev = null;
        }

        // Performs an append LinkedList operation
        private void addToEnd(ListNode node) {
            if (mru == null) {
                lru = node;
            } else {
                mru.next = node;
                node.prev = mru;
            }
            mru = node;
        }

        // Wrapper class for a (k, v) pair node in the LinkedList
        static class ListNode {
            int key;
            int val;
            ListNode prev;
            ListNode next;

            ListNode(int k, int v, ListNode p, ListNode n) {
                key = k;
                val = v;
                prev = p;
                next = n;
            }
        }
    }
}
