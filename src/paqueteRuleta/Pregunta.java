
package paqueteRuleta;

import java.io.Serializable;

public class Pregunta implements Serializable{
    String panel1;
    String panel2;
    String panel3;
    String panel4;
    String pista;
    boolean yaSeleccionada;
    
    public Pregunta (String panel1, String panel2, String panel3, String panel4, String pista){
        this.panel1 = panel1;
        this.panel2 = panel2;
        this.panel3 = panel3;
        this.panel4 = panel4;
        this.pista = pista;
    }
    
    public String toString(){
        return "PISTA: - "+pista+" ----- PANEL: - "+panel1+" "+panel2+" "+panel3+" "+panel4;
    }
}
