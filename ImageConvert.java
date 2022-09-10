import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.lang.Math;




class ImageConvert{

    private int [][][] tab; //tableau 3D. 1> coord X, 2> coord Y, 3> code RGB

    private int largeur = 0;
    private int hauteur = 0;


    public ImageConvert(){//constructeur

        imageTab("sasori.jpg"); //lien image

    }



    //getters & setters

    public int[][][] getTableau(){ return tab;}

    public int getRouge(int x, int y){return tab[y][x][0];}
    public int getVert(int x, int y){return tab[y][x][1];}
    public int getBleu(int x, int y){return tab[y][x][2];}

    public int getHauteur(){return hauteur;}
    public int getLargeur(){return largeur;}





    //méthodes------------------------------------------------------------


    public void imageTab(String nom_fichier){

        BufferedImage img;


        try {
            img = ImageIO.read(new File(nom_fichier));//nom du fichier
            

            largeur = img.getWidth();//largeur
            hauteur = img.getHeight();//hauteur

            tab = new int[hauteur][largeur][3];



            for(int i = 0; i <= tab.length-1; i++){//hauteur

                for(int j = 0; j <= tab[i].length-1; j++){//largeur

                    int[] tabTemp = new int[3];//tab temporaire pour y mettre l'ancien RGB, puis le nouveau après être passé par la procédure "proche"

                    int pixel = img.getRGB(j,i);//récup le code couleur du pixel i,j
                    Color color = new Color(pixel, true);//Conversion code RGB

                    //Récup du RGB dans 3 variables différentes
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    //On place dans temp pour être envoyé en procédure
                    tabTemp[0] = red;
                    tabTemp[1] = green;
                    tabTemp[2] = blue;

                    proche(tabTemp);//Permet de changer la couleur du pixel pour qu'elle corresponde a la couleur choisi

                    //On fout tout dans le tableau 3D de base au bonne coordonnées
                    tab[i][j][0] = tabTemp[0];
                    tab[i][j][1] = tabTemp[1];
                    tab[i][j][2] = tabTemp[2];
 
                    //On recommance pour chaque pixel

                }//for j
            }//for i


        } catch (IOException e) {
        
        }

    }//fin imageTab Math.abs




    //---Les fonctions de barbares qui marche pour faire fonctionner tout ça---\\



    public int indiceMinimum(int [] t){

        int imin = 0;
        int min = t[0];

        for (int i =0; i<= t.length-1;i++){
            if (t[i]<min){
                min = t[i];
                imin = i;
            }
        }
        return imin;

    }//fin indiceMinimum


    public void proche(int[] val){

        
        //Palettes de couleurs
        int[][] TabCouleur = {{101,54,33},{184,8,0},{53,113,112},{49,128,17},{129,129,200}};


        int[] ValRGB = new int[TabCouleur.length];


        for(int i = 0; i<TabCouleur.length; i++){

            for(int j = 0; j<3; j++){

                ValRGB[i] += Math.abs(val[j]-TabCouleur[i][j]);

            }
        }

        int indiceCouleur = indiceMinimum(ValRGB);

        val[0]=TabCouleur[indiceCouleur][0];
        val[1]=TabCouleur[indiceCouleur][1];
        val[2]=TabCouleur[indiceCouleur][2];



    }//fin proche
    


}//fin class
