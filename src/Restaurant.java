
public class Restaurant extends Dinner {
    private String urlPrefix;

    public Restaurant(String NewName) {
        super(NewName);
    }

    public String getURL() {
        urlPrefix = "http://www.bing.com/search?q=";
        String restaurantURL = (urlPrefix + "Restaurant " + getName() + " ");
        return restaurantURL;
    }
}
