

public class NumberLookup extends LookupTable {

    private double number;

    public int getNumber(String color) {

        double number = -1.0;
        if (color.equals("Black")) {
            number = 0.0;
        } else if (color.equals("Brown")) {
            number = 1.0;
        } else if (color.equals("Red")) {
            number = 2.0;
        } else if (color.equals("Orange")) {
            number = 3.0;
        } else if (color.equals("Yellow")) {
            number = 4.0;
        } else if (color.equals("Green")) {
            number = 5.0;
        } else if (color.equals("Blue")) {
            number = 6.0;
        } else if (color.equals("Violet")) {
            number = 7.0;
        } else if (color.equals("Gray")) {
            number = 8.0;
        } else if (color.equals("White")) {
            number = 9.0;
        } else if (color.equals("Gold")) {
            number = -1.0;
        } else if (color.equals("Silver")) {
            number = -1.0;
        }

        return (int) number;
    }

    String [] table =  {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};

    public NumberLookup(String color) {
        super(color);
    }



}
