package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RestaurantRecommendationsTest {
    private OurRestaurantRecommendation recommendation = new OurRestaurantRecommendation();

    @Test
    public void testMakeRestaurantList() {
        String randomURL = recommendation.makeRestaurantList();
        assertNotNull(randomURL);
    }
}
