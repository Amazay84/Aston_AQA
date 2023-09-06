package firstTask;

public class Dog extends Animal {
    private static final int MAX_RUNNING_LENGTH = 500; //meters
    private static final int MAX_SWIMMING_LENGTH = 10; //meters
    private static int dogsCounter;

    public Dog(String dogName) {
        super(dogName);
        dogsCounter++;
    }


    @Override
    public void run(int length) {
        if (length < 0) {
            System.out.printf("%s некуда бежать.\n", this.getDogName());
            return;
        }
        if (length <= MAX_RUNNING_LENGTH) {
            System.out.printf("%s пробежал %d м.\n", this.getDogName(), length);
        } else {
            System.out.printf("%s пробежал %d м и очень устал.\n", this.getDogName(), MAX_RUNNING_LENGTH);
        }
    }

    @Override
    public void swim(int length) {
        if (length < 0) {
            System.out.printf("%s некуда плыть.\n", this.getDogName());
            return;
        }
        if (length <= MAX_SWIMMING_LENGTH) {
            System.out.printf("%s проплыл %d м.\n", this.getDogName(), length);
        } else {
            System.out.printf("%s проплыл %d м и очень устал.\n", this.getDogName(), MAX_SWIMMING_LENGTH);
        }
    }

    public static int getDogsCounter() {
        return dogsCounter;
    }

    public String getDogName() {
        return super.getName();
    }

    public void setDogName(String dogName) {
        super.setName(dogName);
    }
}
