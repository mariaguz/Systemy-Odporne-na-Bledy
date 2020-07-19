#ifndef List_h
#define List_h

#include "Element.h"
/*Klasa przechowująca listę*/
class List {
    el* head;
    el* tail;

public:
    List();
    virtual ~List();
    el* add(double a);
    void showRightToLeft();
    void showLeftToRight();
};

#endif
