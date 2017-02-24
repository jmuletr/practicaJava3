/**
 * Created by jmuletr on 23/02/17.
 *
 */
public class Printer {
    private String alphabet;
    private int counter;
    // Constructor: accepta un String amb la representació de tot l'alfabet
// Hi haurà 27 lletres en total, separades per un espai en blanc.
    public Printer(String alphabet) {
        //assignam la tipografia ascii art a la variable alphabet
        this.alphabet = alphabet;
        //comprovam l'altura de la tipografia
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
        //posam el texte a tractar a majuscules
        text = text.toUpperCase();
        //variable on es generara l'ascii art
        String result = "";
        //valor per pasar a la següent linea del string alphabet
        int newLine = alphabet.length()/ counter +1;
        //valor del caracter a tractar
        int valChar;
        //amplada dels caracters de alphabet
        int widthChar = ((alphabet.length()/27)/ counter + 1);
        //tractam amb i el nombre de linees que ha de tenir el caracter ascii art.
        //amb x tractam la linea del alphabet sumant el valor del caracter per a pasar despres del \n.
        //amb j tractam el caracter del text
        for (int i = 0, x = 0; i < counter; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) > 'A' - 1 && text.charAt(j) < 'Z') {
                    valChar = (text.charAt(j) - 'A') * (widthChar);
                    result += alphabet.substring(valChar+x, (valChar + (widthChar - 1))+x);
                    if (j != text.length() - 1) result += " ";
                }
                //si el caracter es un espai ficam tans espais com l'ample de la tipografia
                else if(text.charAt(j) == ' '){
                    for (int k = 0; k < widthChar; k++) {
                        result+= " ";
                    }
                //tractam tots els caracters restants
                }else{
                    valChar = ('Z' - 'A' + 1) * (widthChar);
                    result += alphabet.substring(valChar+x, (valChar +(widthChar-1))+x);
                    if (j != text.length() - 1) result += " ";
                }
            }
            //sumam x a newline per pasar a la següent linea de alphabet.
            x += newLine;
            //posam salt de linea si no es la darrera.
            if (i < counter - 1) result += "\n";
        }
        //retornam el string del ascii art
        return result;
    }
}
