package firstTask;

public class Cat extends Animal {
    private static final int MAX_RUNNING_LENGTH = 200; //meters
    private static final int MAX_SWIMMING_LENGTH = 0;
    private static int catsCounter;

    public Cat(String catName) {
        super(catName);
        catsCounter++;
    }


    public void run(int length) {
        if (length < 0) {
            System.out.printf("%s некуда бежать.\n", this.getCatName());
            return;
        }
        if (length <= MAX_RUNNING_LENGTH) {
            System.out.printf("%s пробежал %d м.\n", this.getCatName(), length);
        } else {
            System.out.printf("%s пробежал %d м и очень устал.\n", this.getCatName(), MAX_RUNNING_LENGTH);
        }
    }

    @Override
    public void swim(int length) {
        if (length < 0) {
            System.out.printf("%s некуда плыть.\n", this.getCatName());
            return;
        }
        if (length <= MAX_SWIMMING_LENGTH) {
            System.out.printf("%s плавать не пришлось.\n", this.getCatName());
        }
        System.out.printf("%s, как и любой другой кот, не любит плавать.\n", this.getCatName());
    }

    public static int getCatsCounter() {
        return catsCounter;
    }

    public String getCatName() {
        return super.getName();
    }

    public void setCatName(String catName) {
        super.setName(catName);
    }

}
