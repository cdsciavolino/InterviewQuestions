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
    public static int crimeScene(int[] heights) {
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
}
