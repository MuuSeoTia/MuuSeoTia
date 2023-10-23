public class MultiplierLookup extends LookupTable {

    public MultiplierLookup(String color) {
        super(color);
    }

    public String get(String color) {
        return null;
    }

    public int getInt(String color) {
        double multiplier = -3;

        if (color.equals("Black")) {
            multiplier = Math.pow(10, 0);
        } else if (color.equals("Brown")) {
            multiplier = Math.pow(10, 1);
        } else if (color.equals("Red")) {
            multiplier = Math.pow(10, 2);
        } else if (color.equals("Orange")) {
            multiplier = Math.pow(10, 3);
        } else if (color.equals("Yellow")) {
            multiplier = Math.pow(10, 4);
        } else if (color.equals("Green")) {
            multiplier = Math.pow(10, 5);
        } else if (color.equals("Blue")) {
            multiplier = Math.pow(10, 6);
        } else if (color.equals("Violet")) {
            multiplier = Math.pow(10, 7);
        } else if (color.equals("Gray")) {
            multiplier = Math.pow(10, 8);
        } else if (color.equals("White")) {
            multiplier = Math.pow(10, 9);
        } else if (color.equals("Gold")) {
            multiplier = Math.pow(10, -1);
        } else if (color.equals("Silver")) {
            multiplier = Math.pow(10, -2);
        }

        return (int) multiplier;
    }
}
