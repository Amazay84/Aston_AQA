import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruits;

    public Box (ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public List<? extends T> getFruits() {
        return fruits;
    }

    public void addFruit (T... fruit) {
        this.fruits.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        } else {
            return fruits.stream().
                    map(f -> f.getWeight()).
                    reduce(0.0f, (f1, f2) -> f1 + f2);
        }
    }

    public boolean compare (Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void intersperseToAnotherBox(Box<? super T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
