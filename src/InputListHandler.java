import java.util.ArrayList;

public class InputListHandler {
    private Randomizer random = new Randomizer();
    private ArrayList<Dinner> inputList = new ArrayList<Dinner>();

    public ArrayList<Dinner> getArrayList() {
        ArrayList<Dinner> tempList = inputList;
        return tempList;
    }

    public void addMealInputs(String userInput) {
        inputList.add(new Meal(userInput));
    }

    public void addRestaurantInputs(String userInput) {
        inputList.add(new Restaurant(userInput));
    }

    public void clearInputs() {
        inputList.clear();
    }

    public String returnRandomURL() {
        return random.getRandomURL(inputList);
    }
}
