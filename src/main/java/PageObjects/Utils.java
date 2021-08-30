package PageObjects;

import java.util.Random;

public class Utils {
    public static String generateRandomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username"+ randomInt +"@gmail.com";
    }
}
