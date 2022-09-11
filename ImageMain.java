import java.util.Date;
import java.util.Calendar;

/**
 * Convertisseur de couleur d'une image celon une palette selectionnee
 * @author ElCald
 * @version 3
 */

public class ImageMain{


    public static void main(String [] args){

        long ms1 = System.currentTimeMillis();

        Fenetre f = new Fenetre();
        f.setVisible(true);


        //Calcul du temps d'execution
        long ms2 = System.currentTimeMillis();
        long tps = ms2-ms1;
        System.out.println("Fin d'impression");
  
        System.out.println("Temps : "+ tps +"ms");
        System.out.println(tps/1000/60+"m,"+(tps/1000-tps/1000/60)+"s");

        //fichier à executer

    }//fin main

    
}//fin class ImageMain