/**
 * Solutions to Interview Questions of the Day for
 * COS 226 Precept P07 - Fall 2020
 */
import java.util.*;

public class SolutionsFA20 {
    /**
     * [Crime Scene]
     * You're waiting in line at the movies and suddenly out of the blue, the ticket seller at the
     * front of the line gets stabbed and dies! The police are looking for witnesses in the line.
     *
     * Given a line of heights (represented by integers) calculate the number of people in the line
     * who could see the murder at the front. A person can only see the front of the line if he/she
     * is taller than all of the people in front of them.
     *
     * Visually, the line [ 5, 2, 4, 1, 3, 1 ] would look like:
     *
     *              x
     *              x     x
     *              x     x     x
     *              x  x  x     x
     *              x  x  x  x  x  x
     *              __________________  ---(crime scene)---
     *          i = 0  1  2  3  4  5
     *
     * Examples:
     *  (1)     Input: (Back of Line) [5, 2, 4, 1, 3] (Front of line)
     *          Output: 3
     *          Why: The people with heights 5, 4, and 3 are all taller than everyone in front of them
     *
     *  (2)     Input: [5, 4, 3, 2, 1]
     *          Output: 5
     *          Why: Everyone in the line is taller than everyone in front of them
     *
     *  (3)     Input: [1, 2, 3, 4, 5]
     *          Output: 1
     *          Why: 5 is the tallest person in the line and at the front of the line (blocking everyone). Thus, only
     *               he/she can see the front of the line.
     *
     * @param heights - List of heights of the people in the line. Front of the line is at the end of the array.
     * @return - integer corresponding to the number of people who can see the front of the line
     */
    static int crimeScene(int[] heights) {
        // ===== Implementation 1: ======
        // Scan from end of the array
        int maxHeight = Integer.MIN_VALUE;
        int numObservers = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                numObservers++;
                maxHeight = heights[i];
            }
        }
        // return numObservers;
        // ===== !Implementation 1 =====

        // ===== Implementation 2: ======
        // Keep track of heights in a stack
        Stack<Integer> observers = new Stack<Integer>();
        for (int height : heights) {
            while (!observers.isEmpty() && observers.peek() <= height)
                observers.pop();
            observers.push(height);
        }
         return observers.size();
        // ===== !Implementation 2: =====
    }

    /**
     * [Stack with Queues]
     * Implement a Stack (.push(x), .pop(), .peek(), and .isEmpty()) using only
     * queues. You may (at most) use two queues.
     *
     * Leetcode: https://leetcode.com/problems/implement-stack-using-queues/
     *
     * @param <T> The type param of items stored in the Stack
     */
    static class StackWithQueues<T> {
        Queue<T> q1 = new LinkedList<T>(); // Contains all the elements
        Queue<T> q2 = new LinkedList<T>(); // Used for .pop() operation
        T top = null; // Element at the top of the stack

        /**
         * Add `elem` to the top of the stack.
         * @param elem the element to add
         */
        public void push(T elem) {
            q1.add(elem);
            top = elem;
        }

        /**
         * Remove and return the element at the top of the stack.
         *
         * Note: This implementation is O(1) for .push() and O(n) for .pop()
         * This can be reversed by moving the shifting around into the .push()
         * method, which would keep the .pop() method constant time. Depending on
         * read/write load, different implementations would be stronger.
         *
         * @return the element on the top of the stack
         */
        public T pop() {
            // Save the top to return
            T toReturn = top;

            // Move all elements to the second queue except for the last
            while (q1.size() > 1) {
                top = q1.poll();
                q2.add(top);
            }

            // Remove the last element we're returning
            q1.poll();

            // Swap the queues for the next .pop() call
            Queue<T> tmp = q1;
            q1 = q2;
            q2 = tmp;

            // Return the value popped off
            return toReturn;
        }

        /**
         * Return the value of the element at the top of the stack.
         * @return T at the top of the stack
         */
        public T peek() {
            return top;
        }

        /**
         * True if and only if the stack is empty.
         * @return whether the stack has any elements
         */
        public boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    /**
     * [Nearby Toys in Backpack]
     *
     * You're putting toys in a backpack. Each toy has a weight and
     * your backpack can only hold so much weight. The goal is to
     * maximize the number of toys you can put in your backpack
     * without going over the capacity.
     *
     * **IMPORTANT** One constraint is that you can only grab *one
     * contiguous series of toys*. That is, suppose you had toy[] of:
     * [ 1, 2, 3 ]. This means you can only grab [1,2,3], [1,2],
     * [2,3], [1], [2], [3], but NOT [1,3] because they aren't next
     * to each other.
     *
     * Return the maximum number of toys you can bring in your
     * backpack.
     *
     * @param toys - list of toy weights in order.
     * @param capacity - maximum weight of toys you can bring.
     * @return the maximum number of toys you can bring.
     */
    static int fillBackpack(int[] toys, int capacity) {
        // Weight of all toys in [left, right)
        int windowSum = 0;

        // Boundaries of the window
        int left = 0;
        int right = 0;

        // Best weight found so far
        int maxToys = 0;

        while (right < toys.length) {
            // Add the weight of the toy introduced at the boundary
            windowSum += toys[right];

            // Drop items as needed until within capacity
            while (windowSum > capacity)
                windowSum -= toys[left++];

            // Keep track of the most toys observed so far
            maxToys = Math.max(maxToys, right - left + 1);
            right++;
        }
        return maxToys;
    }

    /**
     * [Minimum Remove Parentheses to Make Valid]
     * Given a String of parentheses '(', ')' and lowercase English characters, return
     * the same string with any unnecessary parentheses to make the string valid. A
     * valid string will have:
     * - All opening parentheses match with one closing parentheses
     * - All opening parentheses occur to the left of the closing parentheses
     * - All closing parentheses match with one opening parentheses
     *
     *  Leetcode Reference: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     *
     *  Examples
     *      Input: "lee(t(c)o)de)"
     *      Output: "lee(t(c)o)de" || "lee(t(co)de)" || "lee(t(c)ode)"
     *      Why: One closing parenthesis must be removed to make the string valid
     *
     *      Input: "a)b(c)d"
     *      Output: "ab(c)d
     *      Why: The first closing parentheses must be removed
     *
     *      Input: s = "))(("
     *      Output: ""
     *      Why: An empty string is also a valid return value.
     *
     *      Input: s = "(a(b(c)d)"
     *      Output: "a(b(c)d)" || "(a(bc)d)" || "(ab(c)d)"
     *      Why: One opening parenthesis must be removed.
     *
     * @param s - String of parentheses and characters
     * @return Filtered string s with minimum parentheses removed
     */
    static String minRemoveParentheses(String s) {
        // Indices of all the opening parentheses in the String s
        Stack<Integer> openInds = new Stack<Integer>();

        // Indices of unnecessary parentheses to omit
        Set<Integer> skipInds = new HashSet<Integer>();

        // (1) Identify all the indices to omit
        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);
            if (curCh == '(') openInds.push(i);
            else if (curCh == ')') {
                if (openInds.isEmpty()) skipInds.add(i);
                else openInds.pop();
            }
        }

        // Add all remaining open parentheses indices
        while (!openInds.isEmpty())
            skipInds.add(openInds.pop());

        // (2) Reconstruct the resulting string with omitted characters
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!skipInds.contains(i))
                filtered.append(s.charAt(i));

        return filtered.toString();
    }
}
