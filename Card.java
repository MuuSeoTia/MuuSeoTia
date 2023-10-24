import java.util.*;

public class Card {
    // name of zodiac sign
    String name;
    int day;
    int month;
    String[] fortunes;

    public Card(String name, int month, int day, String[] fortunes) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.fortunes = fortunes;
    }

    public String getRandomFortune() {
        Random random = new Random();
        // return random number between 0 and fortunes.length
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }

}