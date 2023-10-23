public class Program {

    public static void main(String[]arg)
    {

        ResistorDecoder decoder = new ResistorDecoder();
        String [] resistor0 = {"Yellow", "Violet", "Red", "Violet"};
        System.out.println(decoder.decodeResistor(resistor0));

    }
}
