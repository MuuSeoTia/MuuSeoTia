public class ResistorDecoder {
    public String decodeResistor(String[] colors) {


        String decoded = "";

        MultiplierLookup multiplierLookup = new MultiplierLookup(colors[2]);

          int multiplier = multiplierLookup.getInt(colors[2]); ;

          if(multiplier == 1) {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);


              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "Ω";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);
          }
                else if(multiplier == 10)
                  {
                      NumberLookup numberLookup = new NumberLookup(colors[0]);
                      decoded += numberLookup.getNumber(colors[0]);


                      NumberLookup numberLookup1 = new NumberLookup(colors[0]);
                      decoded += numberLookup1.getNumber(colors[1]);

                      decoded += "0 Ω, ";

                      ToleranceLookup toleranceLookup = new ToleranceLookup();
                      decoded += toleranceLookup.get(colors[3]);
                  }

                else if(multiplier == 100)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
                decoded += numberLookup.getNumber(colors[0]);
                decoded += ".";
              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
                decoded += numberLookup1.getNumber(colors[1]);

                decoded += "K Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);

        }

          else if(multiplier == 1000 || multiplier == 10000)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);


              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "K Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);
          }

          else if(multiplier == 100000)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);
              decoded += ".";
              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "M Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);

          }

          else if(multiplier == 1000000 || multiplier == 10000000)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);


              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "M Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);
          }

          else if(multiplier == 100000000)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);
              decoded += ".";
              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "G Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);

          }

          else if(multiplier == 1000000000)
          {
              NumberLookup numberLookup = new NumberLookup(colors[0]);
              decoded += numberLookup.getNumber(colors[0]);


              NumberLookup numberLookup1 = new NumberLookup(colors[0]);
              decoded += numberLookup1.getNumber(colors[1]);

              decoded += "G Ω, ";

              ToleranceLookup toleranceLookup = new ToleranceLookup();
              decoded += toleranceLookup.get(colors[3]);
          }

        return decoded;
    }
}
