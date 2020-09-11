import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
