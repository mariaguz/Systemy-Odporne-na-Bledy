#include "List.h"

/* konstruktor elementu bez paramentru */
List::List() {
    head = NULL;
    tail = NULL;
}

/* Destruktor elementu */
List::~List() {
    el* e = this->head;

    while (e != NULL) {
        el* temp = e;
        e = e->next;
        assert(temp != NULL);
        delete temp;
    }
}

/* Funkcja dodająca element do listy, zwraca wskaźnik do dodanego elementu. */
/// \param _a
/// \return
el* List::add(double _a) {
    el* current = new el(_a);
    assert(current != NULL);

    if (this->head == NULL) {
        this->head = current;
        this->tail = current;
        return current;
    }

    if (current->v < (this->head)->v) {
        el* e = this->head;
        current->next = e;
        e->prev = current;
        this->head = current;
        return current;
    }

    el* next = this->head->next;
    while (next != NULL && current->v > next->v) {
        next = next->next;
    }
    if (next == NULL) {
        el* e = this->tail;
        e->next = current;
        current->prev = e;
        this->tail = current;
        return current;
    }

    el* a = next->prev;
    el* b = next;
    a->next = current;
    b->prev = current;
    current->prev = a;
    current->next = b;
    return current;
}

/* Funkcja wyświetlająca listę od lewej do prawej */
void List::showLeftToRight() {
    el* e = this->head;
    while (e != NULL) {
        cout << e->v << " ";
        e = e->next;
    }
    cout << endl;
}

/* Funkcja wyświetlająca listę od prawej do lewej */
void List::showRightToLeft() {
    el* e = this->tail;
    while (e != NULL) {
        cout << e->v << " ";
        e = e->prev;
    }
    cout << endl;
}