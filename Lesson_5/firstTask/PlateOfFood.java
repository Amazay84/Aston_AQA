package firstTask;

public class PlateOfFood {
    private int capacity;

    public PlateOfFood(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean capacityAfterEating(int eaten) {
        int temp = capacity - eaten;
        if (temp < 0) return false;
        capacity -= eaten;
        return true;
    }

    public void fillingCapacity(int fil) {
        capacity += fil;
    }
}
