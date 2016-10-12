import java.util.ArrayList;

public class RestaurantRecommendations {
    private Randomizer random = new Randomizer();

    public String makeRestaurantList() {
        ArrayList<Dinner> restaurantList = new ArrayList<Dinner>();
        Restaurant Wendys = new Restaurant("Wendys");
        Restaurant OliveGarden = new Restaurant("Olive Garden");
        Restaurant Chilis = new Restaurant("Chilis");
        Restaurant Applebees = new Restaurant("Applebees");
        Restaurant Chickfila = new Restaurant("Chick fil a");
        Restaurant PandaExpress = new Restaurant("Panda Express");
        Restaurant RedLobster = new Restaurant("Red Lobster");
        restaurantList.add(Wendys);
        restaurantList.add(OliveGarden);
        restaurantList.add(Chilis);
        restaurantList.add(Applebees);
        restaurantList.add(Chickfila);
        restaurantList.add(PandaExpress);
        restaurantList.add(RedLobster);
        return random.getRandomURL(restaurantList);
    }
}
