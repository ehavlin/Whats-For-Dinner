import java.util.ArrayList;
import java.util.Random;

public class Randomizer {

    public String getRandomURL(ArrayList<Dinner> foodList) {
        int index = new Random().nextInt(foodList.size());
        Dinner random = foodList.get(index);
        return random.getURL();
    }
}