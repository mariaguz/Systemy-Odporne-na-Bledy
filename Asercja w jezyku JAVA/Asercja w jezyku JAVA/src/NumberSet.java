import java.util.NoSuchElementException;
import java.util.Random;

public class NumberSet {
    public static int MAX_SIZE = 100;
    private int[] nSet;
    private int size;
    /**
     * Constructor
     */
    NumberSet() {
        assert MAX_SIZE > 0: "MAX_SIZE is <= 0";
        nSet = new int[MAX_SIZE];
        size=0;
        assert size == 0;
        assert nSet != null : "nSet is null";
    }

    /**
     * Metoda dodaje liczbę do zbioru liczb
     * (zezwalamy na dodanie liczby już istniejącej)
     *
     * @param i liczba ktora dodajemy
     * @throws Exception występuje w przypadku przepełnienia zbioru
     */
    public void add(int i) throws Exception {
        int oldSize = size;
        assert nSet != null: "nSet is null";

        if (size >= MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("(add) Adding unsuccessfull due to full set");
        }
        else {
            nSet[size] = i;
            setSize(size+1);
        }
        assert nSet[size-1] == i: "nSet[size-1] differ from i";
        assert nSet != null: "nSet is null"; //dodalem
        assert size <= MAX_SIZE: "size is greater than MAX size";//dodalem
        assert oldSize+1 == size: "new size is incorect"; //dodalem
    }

    /**
     * metoda uzywana w remove do asserta dla przypadku z redundacja kodu
     */
    public Integer countOccurred(int val){
        assert nSet != null: "nSet is null";
        Integer ret = 0;

        for(int i=0; i<size; ++i){
            if(nSet[i]==val){
                ++ret;
            }
        }
        assert ret != null: "return value is null";
        assert ret >= 0: "return value must be >= 0";
        return ret;
    }

    /**
     * Metoda usuwa liczbę ze zbioru (każde wystąpienie)
     *
     * @param val liczba do usunięcia
     * @throws Exception występuje jeśli zbiór nie posiada liczby którą chcemy usunąć
     */
    public void remove(int val) throws Exception {
        assert nSet != null: "nSet is null";
        assert size > 0: "size return value <= 0";

        Boolean isInSet = contains(val);
        assert isInSet != null: "isInSet isn't initialized"; // przesunalem, bylo pod ifem 2 linijki niżej
        if (!isInSet)
            throw new NoSuchElementException("(remove) No elements to remove");
        int countOccurred = countOccurred(val);
        int[] tempArr = new int[size];
        int tempSize = 0;

        assert tempArr != null : "tempArr isn't initialized";
        for (int i = 0; i < size; ++i) {
            if (nSet[i] != val) {
                tempArr[tempSize] = nSet[i];
                ++tempSize;
                assert tempSize < size: "new size must be less ";
            }
        }
        assert tempSize == size - countOccurred: "new size is wrong";

        nSet = tempArr;
        size = tempSize;
        assert nSet!=null;
        assert size >= 0: "new size is less than 0";
        assert size <= MAX_SIZE: "new size is bigger than MAX_SIZE";
    }

    /**
     * Metoda losuje jedną liczbę ze zbioru oraz usuwa ją
     *
     * @return wylosowana liczba
     * @throws Exception występuje jeśli zbiór jest pusty
     */
    public int getRandomIndex() throws Exception {
        assert nSet != null: "nSet is null";
        int oldSize = size;
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException("Set is empty");

        Random random = new Random();
        int getRandomIndex = random.nextInt(size);
        assert getRandomIndex<size && getRandomIndex>=0: "Index out of bonds";
        setSize(size-1);

        System.out.println("deleted random value: " + nSet[getRandomIndex] + " from index: " +getRandomIndex);
        nSet[getRandomIndex] = nSet[size];

        assert nSet != null;
        assert oldSize-1 == size;

        return nSet[getRandomIndex];
    }
    /**
     * Metoda zwraca sumę elementów
     *
     * @return Suma liczb.
     * @throws Exception występuje jeśli zbiór jest pusty.
     */
    public int getSumOfElements() throws Exception {
        assert nSet != null: "nSet is null";

        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("(getSumOfElements) set is empty");
        }

        int sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += nSet[i];
        }

        assert isObjectInteger(sum): "Sum is not integer";
        return sum;
    }

    /**
     * Metoda dzieli każdy element zbioru przez podaną wartość bez reszty
     *
     * @param d liczba przez którą dzielimy
     * @throws Exception występuje w przypadku dzielenia przez 0 (można zastąpić asercją)
     *
     */
    public void divideAllElements(int d) {
        assert nSet != null: "nSet is null";

        if(d == 0){ throw new IllegalArgumentException("Dividing by 0 is prohibited"); }

        for (int i = 0; i < size; ++i) {
            assert d != 0: "Dividing by 0 is prohibited";
            nSet[i] /= d;
            assert isObjectInteger(nSet[i]): "Error during dividing";
        }
        assert nSet != null: "nSet is null";
        assert size <= MAX_SIZE: "size is over MAX_SIZE";
        assert size >=0 : "size is less than 0";
    }

    /**
     * Metoda sprawdza czy w zbiorze istnieje podany element
     *
     * @param i element do sprawdzenia
     * @return true
     * w przypadku odnalezienia wartości,
     * w przypadku odnalezienia wartości
     * <p>
     * false
     * w przeciwnym razie.
     */
    public Boolean contains(int i) {
        assert nSet != null: "nSet is null";

        Boolean isInSet = false;
        for (int j = 0; j < size; ++j) {
            if (nSet[j] == i) {
                isInSet = true;
                break;
            }
        }

        assert isInSet != null: "isInSet variable isn't initialized";

        return isInSet;
    }


    public int getSize(){
        assert size >= 0 : "Size is less than 0";
        assert size <= MAX_SIZE : "Size is bigger than MAX_SIZE";
        return size;
    }

    /**
     * Metoda ustawia rozmiar zbioru (liczbę elementów)
     *
     * @param size - nowy rozmiar zbioru
     */
    public void setSize(int size) {
        assert size <= MAX_SIZE: "size must be less than MAX_SIZE";
        assert size >= 0: "size can't be less than 0";

        if(size <= MAX_SIZE) {
            this.size = size;
        }
            else{
                throw new IllegalArgumentException("size must be lower than MAX_SIZE");
            }


        assert this.size == size: "something is wrong with the size assignment";
    }

    /**
     * Metoda wyświetla zbiór.
     */
    void showArr() {
        StringBuilder sb = new StringBuilder("nSet: ");
        for (int i = 0; i < size; ++i) {
            sb.append(nSet[i]);
            sb.append("  ");
            if(i%10 == 0 && i != 0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    /**
     *
     * @param o objekt do sprawdzenia typu
     * @return prawda dla integerów, fałsz dla reszty
     */
    private boolean isObjectInteger(Object o) { return Integer.class.isInstance(o); }
}


