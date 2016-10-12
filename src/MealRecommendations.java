import java.util.ArrayList;

public class MealRecommendations {
    private Randomizer random = new Randomizer();

    public String makeMealList() {
        ArrayList<Dinner> mealList = new ArrayList<Dinner>();
        Meal Sushi = new Meal("Sushi");
        Meal Steak = new Meal("Steak");
        Meal ChickenChili = new Meal("Chicken Chili");
        Meal Chicken = new Meal("Chicken");
        Meal ApplePorkChops = new Meal("Apple Pork Chops");
        mealList.add(Sushi);
        mealList.add(Steak);
        mealList.add(ChickenChili);
        mealList.add(Chicken);
        mealList.add(ApplePorkChops);
        return random.getRandomURL(mealList);
    }
}
