package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MealTest {
    String mealObjectName = "testMealName";
    public Meal meal = new Meal(mealObjectName);

    @Test
    public void testMealName() {
        assertEquals(mealObjectName, meal.getName());
    }

    @Test
    public void testMealGetURL() {
        String testURL = "http://www.recipe.com/search/?searchTerm=" + mealObjectName;
        assertEquals(testURL, meal.getURL());
    }
}
