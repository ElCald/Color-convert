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

    // public BufferedImage Capture(Component compo){

    //     BufferedImage image = new BufferedImage(compo.getWidth(), compo.getHeight(), BufferedImage.TYPE_INT_RGB);
    //     compo.paint(image.getGraphics());
    //     return image;

    // }

  // public void Sauvegarder(Component compo){

    //     BufferedImage imageS = Capture(compo);
    //     try{
    //         ImageIO.write(imageS, "jpg", new File("jenifail2bis.jpg"));
    //     }catch(IOException e){e.printStackTrace();}  

    // }

//    public void Sauvegarder(Component compo){

//         BufferedImage image = new BufferedImage(compo.getWidth(), compo.getHeight(), BufferedImage.TYPE_INT_RGB);
//         Graphics2D g = image.createGraphics();
//         compo.printAll(g);
//         g.dispose();
//         try{
//             ImageIO.write(image, "jpg", new File("jenifail2bis.jpg"));
//         }
//         catch(IOException e){e.printStackTrace();}  

//     }




} 