#ifndef COLOR_CONVERT_H
#define COLOR_CONVERT_H

#include <vector>
#include <opencv2/opencv.hpp>
#include <iostream>


#define T_TAB_COLORS 5 



using namespace std;

class Color_swap {
    private:
        vector<vector<int>> liste_couleurs;

        cv::Mat ouvrir_image(char* nomImage);
        void creer_image(char* nomImage, cv::Mat image);
        int plus_proche_color(cv::Vec3b &pixel);

    public:
        Color_swap(vector<vector<int>> liste);
        ~Color_swap();
        void swap_color(char* nomImage);
        
};


#endif