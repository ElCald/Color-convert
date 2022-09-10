import javax.swing.JFrame;

public class Fenetre extends JFrame{

    public Fenetre(){

        setTitle("Fentre");
        setSize(680, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new Panel());

    }

}