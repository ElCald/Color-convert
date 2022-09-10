import javax.swing.JFrame;

public class Fenetre extends JFrame{

    public Fenetre(){

        ImageConvert img = new ImageConvert();

        setTitle("Image");
        setSize(img.getLargeur(), img.getHauteur());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new Panel());

    }

}