package firstTask;

public class Dog extends Animal {
    private static final int MAX_RUNNING_LENGTH = 500; //meters
    private static final int MAX_SWIMMING_LENGTH = 10;
    private static int dogsCounter;

    public Dog(String dogName) {
        super(dogName);
        dogsCounter++;
    }


    @Override
    public void run(int length) {
        for (int i = 0; i < length; i++) {
            try {
                if (i < MAX_RUNNING_LENGTH) {
                Thread.sleep(50);
                System.out.printf("%s пробежал %d м.\n", this.getDogName(), i);
            } else {
                    System.out.printf("%s пробежал %d м и очень устал.\n", this.getDogName(), i);
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void swim(int length) {
        for (int i = 0; i < length; i++) {
            try {
                if (i < MAX_SWIMMING_LENGTH) {
                    Thread.sleep(50);
                    System.out.printf("%s проплыл %d м.\n", this.getDogName(), i);
                } else {
                    System.out.printf("%s проплыл %d м и очень устал.\n", this.getDogName(), i);
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
