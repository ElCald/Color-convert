#include <vector>
#include <cmath>
#include <chrono>
#include <iostream>
#include <string>
#include <omp.h>


#include "color_convert.h"

using namespace std;

Color_swap::Color_swap(vector<vector<int>>  liste) {
    for(vector<int> color : liste){
        liste_couleurs.push_back(color);
    }

    cout << "Nombre de couleurs : " << liste_couleurs.size() << endl;
}

Color_swap::~Color_swap(){}


void Color_swap::swap_color(char* nomImage){

    cv::Mat image = ouvrir_image(nomImage);

    #pragma omp parallel
    {
        #pragma omp single
        cout << "Nb threads : " << omp_get_num_threads() << endl; 
    }

   
    #pragma omp parallel for collapse(2)
    for (int y = 0; y < image.rows; y++) {
        for (int x = 0; x < image.cols; x++) {
           
            cv::Vec3b &color = image.at<cv::Vec3b>(y, x);

            // Modifier les valeurs RGB 
            color[0] = liste_couleurs.at(plus_proche_color(color)).at(0);
            color[1] = liste_couleurs.at(plus_proche_color(color)).at(1);
            color[2] = liste_couleurs.at(plus_proche_color(color)).at(2);
        }
    }
    


    creer_image(nomImage, image);

} //fin swap_color


cv::Mat Color_swap::ouvrir_image(char* nomImage){

    cv::Mat image = cv::imread(nomImage);

    if (image.empty()) { // Vérification de si l'image existe
        cerr << "Erreur de lecture de l'image !" << endl;
        exit(EXIT_FAILURE);
    }

    return image;
} //fin ouvrir_image


void Color_swap::creer_image(char* nomImage, cv::Mat image){

    auto now = chrono::system_clock::now();
    
    // Convertir en temps écoulé depuis l'époque en millisecondes
    auto duration = chrono::duration_cast<chrono::milliseconds>(now.time_since_epoch());
    
    string fichier_modifie = "swap-" + to_string(duration.count()) + "-" + string(nomImage);

    cv::imwrite(fichier_modifie.c_str(), image);

    std::cout << "Image swappée et enregistrée !" << std::endl;
} //fin creer_image


int Color_swap::plus_proche_color(cv::Vec3b &pixel){
    int i_min, som = 0, som_min = INT_MAX;

    for(vector<std::vector<int>>::size_type i=0; i<liste_couleurs.size(); i++){
        som += abs(liste_couleurs.at(i).at(0) - pixel[0]);
        som += abs(liste_couleurs.at(i).at(1) - pixel[1]);
        som += abs(liste_couleurs.at(i).at(2) - pixel[2]);

        if(som < som_min){
            som_min = som;
            i_min = i;
        }

        som = 0;
    }

    return i_min;
} //fin plus_proche_color