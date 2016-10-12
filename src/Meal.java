
public class Meal extends Dinner {
    private String urlPrefix;

    public Meal(String NewName) {
        super(NewName);
    }

    public String getURL() {
        urlPrefix = "http://www.recipe.com/search/?searchTerm=";
        String mealURL = (urlPrefix + getName());
        return mealURL;
    }
}
