public class ToleranceLookup {

    public String get(String color) {
        String tolerance = "";
        if (color.equals("Black")) {
            tolerance = "";
        } else if (color.equals("Brown")) {
            tolerance = "±1%";
        } else if (color.equals("Red")) {
            tolerance = "±2%";
        } else if (color.equals("Orange")) {
            tolerance = "";
        } else if (color.equals("Yellow")) {
            tolerance = "±5%";
        } else if (color.equals("Green")) {
            tolerance = "±0.5%";
        } else if (color.equals("Blue")) {
            tolerance = "±0.25%";
        } else if (color.equals("Violet")) {
            tolerance = "±0.1%";
        } else if (color.equals("Gray")) {
            tolerance = "±10%";
        } else if (color.equals("White")) {
            tolerance = "";
        } else if (color.equals("Gold")) {
            tolerance = "±5%";
        } else if (color.equals("Silver")) {
            tolerance = "±10%";
        }

        return tolerance;
    }
}
