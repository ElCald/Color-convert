# Color-convert
Change les pixels d'une image selon une palette de couleur (RGB) définie.
La couleur du pixel est choisi en fonction de son code RGB le plus proche avec celui d'une couleur de la palette.
Le programme change bloc par bloc (de pixels) sur la ligne.

------
### Version C++
- Bibliothèques : Opencv et OpenMP
- Compilation
  - Séquentielle :  ```make```
  - Parallèle :  ```make omp``` (besoin de la bibliothèque OpenMP)
- Changer la palette : modifier le tableau "tab_colors" dans le fichier  ```main.cpp```
- Exectution  ```./main nom_image.ext```
------
### Version JAVA
- Compilation des fichiers : ```javac *.java ```
- Changer l'image : ImageConvert.java, __ligne 23 & 24__. *(Fichier à recompiler)*
- Changer la palette : ImageConvert.java, __ligne 142__. *(Fichier à recompiler)*
- Executer ImageMain.java

Le temps d'exectution varie en fonction la taille de l'image et celle de la palette.


(Optimisation approximative, l'éxecution peut prendre plusieurs minutes ! )

# Exemple : 

### Original
![Alt text](https://github.com/ElCald/Color-convert/blob/main/Exemple/original.jpg?raw=true)
Credit : Anato Finnstark
### Colored
![Alt text](https://github.com/ElCald/Color-convert/blob/main/Exemple/original-swap.jpg?raw=true)
### Palette
![Alt text](https://github.com/ElCald/Color-convert/blob/main/Exemple/palette.png?raw=true)

Credit image original : [Anato Finnstark](https://www.artstation.com/artwork/rnDN5)
