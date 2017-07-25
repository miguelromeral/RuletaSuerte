
package paqueteRuleta;

import java.io.Serializable;
import java.util.*;

public class Programa implements Serializable{
    ArrayList<Pregunta> baseDatos = new ArrayList<Pregunta>();
    
    public Programa (){
        baseDatos = new ArrayList<Pregunta>();
    }
    
    public Pregunta seleccionar(){
        try{
            Pregunta seleccionada;
            int numero;
            Random rand = new Random();
            int i=0;
            for(i=0; i<2*baseDatos.size(); i++){
                numero = rand.nextInt(baseDatos.size());
                seleccionada = baseDatos.get(numero);
                if(!seleccionada.yaSeleccionada){
                    seleccionada.yaSeleccionada = true;
                    return seleccionada;
                }else{
                    i++;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void nuevaPregunta(String panel1, String panel2, String panel3, String panel4, String pista){
        Pregunta nueva = new Pregunta(panel1, panel2, panel3, panel4, pista);
        this.baseDatos.add(nueva);
        System.out.println("Pregunta añadida con exito.");
    }
}
