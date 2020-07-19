#include <memory>
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

#define NUMBER_OF_POINTERS 20

void print(shared_ptr<double>* pointers){
    for (int i = 0; i < NUMBER_OF_POINTERS; ++i) {
        printf("[%d] %f\n", i, *pointers[i]);
    }
    cout << endl;
}

void print(weak_ptr<double>* weakPointers) {
    shared_ptr<double> val;
    for (int i = 0; i < NUMBER_OF_POINTERS;  ++i) {
        if (weakPointers[i].lock()) {
            printf("[%d] %f\n", i, *weakPointers[i].lock());
        }
        else {
            printf("[%d] usunieta\n", i);
        }
    }
}

float randFloat(int a, int b){
    return (1.0 * rand() / (RAND_MAX)) * (b - a) + a;
}

void deleteRandomValue(shared_ptr<double>* pointers) {
    int randPointer = rand() % NUMBER_OF_POINTERS;
    pointers[randPointer].~shared_ptr();
}

int main(void) {
    shared_ptr<double> pointers[NUMBER_OF_POINTERS];
    weak_ptr<double> weakPointers[NUMBER_OF_POINTERS];

    srand(time(NULL));
    float randomValue;
    for (int i = 0; i < NUMBER_OF_POINTERS; ++i) {
        // losuje wartosci z przedzialu [-25, 25]
        randomValue = randFloat(-25, 25);

        //zapisuje wartosci do wskaznika
        pointers[i] = make_shared<double>(randomValue);

        // "obserwator" wskaznikow pointers
        weakPointers[i] = pointers[i];
    }

    //wypisuje wylosowane liczby
    print(pointers);

    //usuwam losowa wartosc
    deleteRandomValue(pointers);

    //wypisuje wartosci z oznaczeniem usunietej
    print(weakPointers);

    return 0;
}