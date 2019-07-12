package ps;

import java.util.ArrayList;
/**
 *
 * @author Vinicius Geraldo
 */
public class Ligador {

    private ArrayList<String> cod1, cod2, codComposto;

    public Ligador(ArrayList<String> cod1, ArrayList<String> cod2) {
        this.cod1 = cod1;
        this.cod2 = cod2;
        this.codComposto = new ArrayList<>();
    }

    ArrayList ligar() {
        int i = 0;
        String aux = "";
        while (i < cod1.size()) {
            aux = cod1.get(i);
            if (aux.contains("INTUSE") || aux.contains("EXTDEF")) {
                i++;
            } else {
                this.codComposto.add(aux);
                i++;
            }
        }
        i = 0;
        aux = "";
        while (i < cod2.size()) {
            aux = cod2.get(i);
            if (aux.contains("INTUSE") || aux.contains("EXTDEF")) {
                i++;
            } else {
                this.codComposto.add(aux);
                i++;
            }
        }
        return this.codComposto;
    }
}
