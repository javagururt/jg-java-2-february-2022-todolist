import java.util.Random;
import java.util.UUID;

class RandomNameGenerator {

    public String generateRandomName() {
        int number = getNumber();
        return String.valueOf(number);
    }

    protected int getNumber() {
        Random random = new Random();
        var number = random.nextInt();
        return number;
    }
}
