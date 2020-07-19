#ifndef Element_h
#define Element_h

#include <iostream>
#include <string>
#include <cstdlib>
#include <fstream>

//#define NDEBUG
#include <cassert>

using namespace std;

/* Struktura przechowująca pojedynczy obiekt listy */
struct el {
    double v;
    el* next;
    el* prev;
    el();
    el(double  v);
    virtual ~el();
};

#endif
