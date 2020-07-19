public class NumberSetTest  {
    public NumberSetTest() throws Exception {
        NumberSet numberSet = new NumberSet();
        for(int i=0; i<100; ++i){
            try {
                numberSet.add(i * 2);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        numberSet.showArr();
        System.out.println("Ilosc wystapien 2: "+numberSet.countOccurred(2));

        //dzielenie
        try {
            numberSet.divideAllElements(2);
        }catch(Exception e){
            System.out.println(e);
        }
        numberSet.showArr();
        for(int i = 3; i<=99; ++i) {
            try{
                numberSet.remove(i);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        numberSet.showArr();
        numberSet.getRandomIndex();
        numberSet.showArr();

        System.out.println("suma: "+numberSet.getSumOfElements());

        System.out.println("rozmiar: "+numberSet.getSize());
        try{
            numberSet.add(99);
        }
        catch (Exception e){
            System.out.println(e);
        }
        numberSet.showArr();
        System.out.println("rozmiar: "+numberSet.getSize());
    }
}