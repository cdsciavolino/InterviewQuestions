import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionsFA20Test {
    @Test
    public void testCrimeScene() {
        int[] ex1 = new int[]{5, 2, 4, 1, 3};
        assertEquals(3, SolutionsFA20.crimeScene(ex1));
        int[] ex2 = new int[]{5, 4, 3, 2, 1};
        assertEquals(5, SolutionsFA20.crimeScene(ex2));
        int[] ex3 = new int[]{1, 2, 3, 4, 5};
        assertEquals(1, SolutionsFA20.crimeScene(ex3));
        assertEquals(0, SolutionsFA20.crimeScene(new int[]{}));
    }

    @Test
    public void testStackWithQueues() {
        SolutionsFA20.StackWithQueues<Integer> stack = new SolutionsFA20.StackWithQueues<>();
        stack.push(1);
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.pop());
        stack.push(6);
        stack.push(7);
        assertEquals(7, stack.peek());
        assertEquals(7, stack.pop());
        assertEquals(6, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    public void testFillBackpack() {
        assertEquals(2, SolutionsFA20.fillBackpack(new int[]{1, 2, 3}, 3));
        assertEquals(2, SolutionsFA20.fillBackpack(new int[]{1, 2, 3}, 5));
        assertEquals(3, SolutionsFA20.fillBackpack(new int[]{1, 2, 3}, 6));
        assertEquals(3, SolutionsFA20.fillBackpack(new int[]{1, 2, 3}, 7));
        assertEquals(1, SolutionsFA20.fillBackpack(new int[]{1, 2, 3}, 1));
        assertEquals(1, SolutionsFA20.fillBackpack(
                new int[]{1, 2, 3, 1, 7, 2, 4, 9},
                2
        ));
        assertEquals(4, SolutionsFA20.fillBackpack(
                new int[]{1, 2, 3, 1, 7, 2, 4, 9},
                12
        ));
    }

    @Test
    public void testMinRemoveParentheses() {
        Set<String> expected = new HashSet<String>();
        expected.add("lee(t(c)o)de");
        expected.add("lee(t(co)de)");
        expected.add("lee(t(c)ode)");
        assertTrue(expected.contains(SolutionsFA20.minRemoveParentheses("lee(t(c)o)de)")));

        assertEquals("ab(c)d", SolutionsFA20.minRemoveParentheses("a)b(c)d"));
        assertEquals("", SolutionsFA20.minRemoveParentheses("))(("));

        expected = new HashSet<String>();
        expected.add("a(b(c)d)");
        expected.add("(a(bc)d)");
        expected.add("(ab(c)d)");
        assertTrue(expected.contains(SolutionsFA20.minRemoveParentheses("(a(b(c)d)")));
    }
}
