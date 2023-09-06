package firstTask;

public class Cat extends Animal {
    private static final int MAX_RUNNING_LENGTH = 200; //meters
    private static final int MAX_SWIMMING_LENGTH = 0;
    private static int catsCounter;

    public Cat(String catName) {
        super(catName);
        catsCounter++;
    }


    @Override
    public void run(int length) {

    }

    @Override
    public void swim(int length) {

    }

    public static int getCatsCounter() {
        return catsCounter;
    }
}
