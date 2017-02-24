/**
 * Created by jmuletr on 23/02/17.
 */
public class Printer {
    private String alphabet;
    private int counter;
    // Constructor: accepta un String amb la representació de tot l'alfabet
// Hi haurà 27 lletres en total, separades per un espai en blanc.
    public Printer(String alphabet) {
        this.alphabet = alphabet;

        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == '\n') counter++;

        }
        counter++;
    }

    // Mètode render: accepta un String amb el text a representar i torna
// també un String amb el text en forma d'ASCII Art.
// Només es consideren les lletres majúscules de la A a la Z. Les
// minúscules es passen a majúscules, i els altres caràctes es tradueixen
// a «?» (manco l'espai en blanc).
    public String render(String text) {
        text = text.toUpperCase();
        String result = "";
        int newLine = alphabet.length()/ counter +1;
        int valChar;
        int widthChar = ((alphabet.length()/27)/ counter + 1);
        for (int i = 0, x = 0; i < counter; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) > 64 && text.charAt(j) < 91) {
                    valChar = (text.charAt(j) - 'A') * (widthChar);
                    result += alphabet.substring(valChar+x, (valChar + (widthChar - 1))+x);
                    if (j != text.length() - 1) result += " ";
                }
                else if(text.charAt(j) == 32 && counter == 5){
                    result+= "    ";

                }else if(text.charAt(j) == 32 && counter == 3){
                    result+= "      ";

                }else{
                    valChar = ('Z' - 'A' + 1) * (widthChar);
                    result += alphabet.substring(valChar+x, (valChar +(widthChar-1))+x);
                    if (j != text.length() - 1) result += " ";
                }
            }
            x += newLine;
            if (i < counter - 1) result += "\n";
        }
        System.out.println(result);
        return result;
    }
}
