import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class Panel extends JPanel{

    public void paint(Graphics g){

        ImageConvert img = new ImageConvert();

        for(int i = 0; i <img.getHauteur(); i++){

            for(int j = 0; j <img.getLargeur(); j++){

                g.setColor(new Color(img.getRouge(j, i), img.getVert(j, i), img.getBleu(j, i)));
                g.fillRect(j,i,j,i);
            }
        }

        System.out.println("Fin d'impression");

        
    }

}