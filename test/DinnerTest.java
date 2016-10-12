package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DinnerTest {
    String dinnerObjectName = "testDinnerName";
    private Dinner dinner = new Dinner(dinnerObjectName);

    @Test
    public void testDinner() {
        assertEquals(dinnerObjectName, dinner.getName());
    }
}