package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InputListHandlerTest {
    private String meal = new String();
    private String restaurant = new String();
    private InputListHandler createInputList = new InputListHandler();

    @Test
    public void testMealInput() {
        meal = "Sushi";
        createInputList.addMealInputs(meal);
        assertEquals(meal, createInputList.getArrayList().get(0).getName());
    }

    @Test
    public void testRestaurantInput() {
        restaurant = "Ami";
        createInputList.addRestaurantInputs(restaurant);
        assertEquals(restaurant, createInputList.getArrayList().get(0).getName());
    }

    @Test
    public void testMealInputsInternational() {
        meal = "すし";
        createInputList.addMealInputs(meal);
        assertEquals(meal, createInputList.getArrayList().get(0).getName());
    }

    @Test
    public void testRestaurantInputsInternational() {
        restaurant = "マクドナルド";
        createInputList.addRestaurantInputs(restaurant);
        assertEquals(restaurant, createInputList.getArrayList().get(0).getName());
    }

    @Test
    public void testCreateInputListMeal() {
        meal = "Sushi";
        createInputList.addMealInputs(meal);
        String URL = ("http://www.recipe.com/search/?searchTerm=" + meal);
        assertEquals(URL, createInputList.returnRandomURL());
    }

    @Test
    public void testCreateInputListRestaurant() {
        restaurant = "Ami";
        createInputList.addRestaurantInputs(restaurant);
        String URL = ("https://www.google.com/#q=" + restaurant + " restaurant");
        assertEquals(URL, createInputList.returnRandomURL());
    }

    @Test
    public void testGetArrayList() {
        restaurant = "Ami";
        createInputList.addRestaurantInputs(restaurant);
        assertEquals(restaurant, createInputList.getArrayList().get(0).getName());
    }

    @Test
    public void testClearInputs() {
        meal = "Sushi";
        createInputList.addMealInputs(meal);
        createInputList.clearInputs();
        assertTrue(createInputList.getArrayList().isEmpty());
    }

}