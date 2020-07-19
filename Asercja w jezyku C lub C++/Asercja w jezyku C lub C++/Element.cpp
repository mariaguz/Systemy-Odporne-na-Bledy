#include "Element.h"
/* Konstruktor elementu bez parametru*/
el::el() {
    next = NULL;
    prev = NULL;
}

/* Konstruktor elementu z parametrem */
el::el(double temp) {
    assert(temp != NULL);
    next = NULL;
    prev = NULL;
    this->v = temp;
}

/* Destruktor elementu */
el::~el() {
    el* a = this->prev;
    el* b = this->next;
    if (a != NULL)
        a->next = b;
    if (b != NULL)
        b->prev = a;
}