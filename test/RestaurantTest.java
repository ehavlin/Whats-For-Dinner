package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantTest {
    private Restaurant restaurant = new Restaurant("testRestaurantName");

    @Test
    public void testRestaurantName() {
        assertEquals("testRestaurantName", restaurant.getName());
    }

    @Test
    public void testRestaurantGetURL() {
        String testURL = "https://www.google.com/#q=" + "testRestaurantName" + " restaurant";
        assertEquals(testURL, restaurant.getURL());
    }
}
