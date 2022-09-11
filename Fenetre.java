import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;

/**
 * Affichage a l'ecran ou sauvegarde de l'image
 * @author ElCald
 */

public class Fenetre extends JFrame{

    ImageConvert img = new ImageConvert();

    public Fenetre(){

        Panel imageDessin = new Panel();

        setTitle("Image");
        setSize(img.getLargeur(), img.getHauteur());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(imageDessin);
        

        pack();
        BufferedImage image = new BufferedImage(img.getLargeur(), img.getHauteur(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        imageDessin.paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(image, img.getExtImg(), new File(img.getNomImg()+"-swap."+img.getExtImg()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        dispose();

    }


}//fin class fenetre