import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Date;
import java.util.Calendar;

/**
 * Affichage dans un panel pixel par pixel ou via bande de pixel
 * @author ElCald
 */

class Panel extends JPanel{

    ImageConvert img = new ImageConvert();

    public void paint(Graphics g){

        
        long ms1 = System.currentTimeMillis();
        
        
        for(int i = 0; i <img.getHauteur(); i++){

            int j = 0;
            int n = 0;

            while(j+n<img.getLargeur()){

                //Méthode pour remplir des bandes de pixels
                while(j+n<img.getLargeur() && img.getRouge(j, i)==img.getRouge(j+n, i) && img.getVert(j, i)==img.getVert(j+n, i) && img.getBleu(j, i)==img.getBleu(j+n, i)){
  
                    n++;
   
                }   

                g.setColor(new Color(img.getRouge(j, i), img.getVert(j, i), img.getBleu(j, i)));
                g.fillRect(j,i,j+n,i);

                j += n;

                n=0;
            }
           


            //pixel par pixel
            // for(int j = 0; j < img.getLargeur(); j++){

            //     g.setColor(new Color(img.getRouge(j, i), img.getVert(j, i), img.getBleu(j, i)));
            //     g.fillRect(j,i,j,i);
               
            // }
        }

        long ms2 = System.currentTimeMillis();
        long tps = ms2-ms1;
        System.out.println("Fin d'impression");
  
        System.out.println("Temps : "+ tps +"ms");
        System.out.println(tps/1000/60+"."+(tps/1000-tps/1000/60));


        
    }


}//fin class