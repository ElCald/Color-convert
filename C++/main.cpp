#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <time.h>
#include <omp.h>

#include "color_convert.h"


#define NB_PARAM 1

using namespace std;


int main(int argc, char* argv[]) {

    if(argc != NB_PARAM + 1){
        cerr << "Paramètre : nom image" << endl;
        exit(EXIT_FAILURE);
    }
    
    
    clock_t start, stop;  
    double start_p, stop_p, CPU_time, total;    // omp

    
    #ifndef _OPENMP
        cout << "Execution séquentielle..." << endl;
        start = clock();
    #else
        cout << "Execution parallèle..." << endl;
        start_p = omp_get_wtime();
    #endif


    

    vector<vector<int>> couleurs;
    vector<vector<int>> couleurs1;
    vector<vector<int>> couleurs2;
    vector<vector<int>> couleurs3;
    
    int tab_colors[T_TAB_COLORS][3] = {
        {28,14,98},
        {118,182,181},
        {157,155,87},
        {86,253,66},
        {246,122,86}
    };

    int TabCouleur1[8][3] = {{46,46,38},{242,231,213},{80,73,65},{130,130,130},{25,22,17},{70,81,87},{107,81,66},{59,70,74}};
    int TabCouleur2[5][3] = {{101,54,33},{184,8,0},{53,113,112},{49,128,17},{129,129,200}};
    int TabCouleur3[8][3] = {{56, 68, 73},{107, 80, 64},{68, 80, 86},{18, 14, 9},{242, 232, 214},{79, 71, 63},{42, 42, 33},{131, 131, 131}};


    for(int i=0; i<T_TAB_COLORS; i++){
        couleurs.push_back(vector<int>(tab_colors[i], tab_colors[i] + 3));
    }
    for(int i=0; i<8; i++){
        couleurs1.push_back(vector<int>(TabCouleur1[i], TabCouleur1[i] + 3));
    }
    for(int i=0; i<5; i++){
        couleurs2.push_back(vector<int>(TabCouleur2[i], TabCouleur2[i] + 3));
    }

    for(int i=0; i<8; i++){
        couleurs3.push_back(vector<int>(TabCouleur3[i], TabCouleur3[i] + 3));
    }



    // Color_swap swapper(couleurs);
    // Color_swap swapper1(couleurs1);
    // Color_swap swapper2(couleurs2);
    Color_swap swapper3(couleurs3);


    // swapper.swap_color(argv[1]);
    // swapper1.swap_color(argv[1]);

    swapper3.swap_color(argv[1]);

    #ifndef _OPENMP
        stop = clock();
        total = (double)stop - start;
        CPU_time = total / CLOCKS_PER_SEC;
    #else
        stop_p = omp_get_wtime();
        CPU_time = stop_p - start_p;
    #endif

    cout << "Time : " << CPU_time << " seconds" << endl;

    
}// fin main