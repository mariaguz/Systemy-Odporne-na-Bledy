#include "Element.cpp"
#include "List.cpp"
#include <iostream>
#include <string>
#include <cstdlib>
#include <fstream>

using namespace std;

/*Funkcja sprawdzająca, czy wartość argumentu val mieści się w podanym zakresie (min-max), jeśli tak, dodaje element listy.*/
/// \param val
/// \param min
/// \param max
/// \param list
void checkRangeAndAddToList(double val, int min, int max, List* list) {
    assert(list != nullptr);
    assert(max > min);
    assert (val >= min && val <= max);

    if(val >= min && val <= max) {
        list->add(val);
        cout << val << " is in range " << min << ":" << max << "." << endl;

        assert(list != nullptr);
    }

}

/*Funkcja sprawdzająca czy wprowadzony argument jest liczbą, zwracający prawdę dla liczb i fałsz dla reszty */
/// \param i
/// \param str
/// \returnp
bool isNumber(double& i, const string& str) {
    try {
        size_t pos;
        i = stod(str, &pos);
        return pos == str.size();
    }
    catch (const std::invalid_argument&) {
        return false;
    }
}

int main(int argc, char* argv[]){
    assert(argc == 4);

    string fileName = argv[1];
    int min = atoi(argv[2]);
    int max = atoi(argv[3]);


    ifstream file;
    file.open(fileName, std::fstream::in);
    assert(file.good());

    List* list = new List;
    assert(list != NULL);

    string number;
    while (!file.eof()) {
        getline(file, number);
        double i;

        bool isCorrect = isNumber(i, number);
        assert(isCorrect);
        checkRangeAndAddToList(i, min, max, list);
    }

    file.close();

    cout << "======================== " << endl;
    cout << "List from left to right: " << endl;
    list->showLeftToRight();

    cout << "======================== " << endl;
    cout << "List from right to left: " << endl;
    list->showRightToLeft();

    delete list;
    system("PAUSE");
    return 0;
}
