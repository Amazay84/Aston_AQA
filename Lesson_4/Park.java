import java.util.ArrayList;
import java.util.List;

public class Park {
    private Attractions attractions;
    public Park(Attractions attractions) {
       this.attractions = attractions;
    }

    public Park() {
    }

    public Attractions getAttractions() {
        return attractions;
    }

    public void setAttractions(Attractions attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().concat(" {" +
                "attractions=" + attractions +
                '}');
    }

    private class Attractions {
        private String name;
        private String workingHours;
        private double cost;

        public Attractions(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public Attractions() {}

        public double getCost() {
            return cost;
        }
        public String getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName().concat(" {" +
                    " name = '" + name + '\'' +
                    ", workingHours = '" + workingHours + '\'' +
                    ", cost = " + cost +
                    " } ");
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Park parkWithAttractions = new Park(park.new Attractions("Центрифуга", "10:00 - 20:00", 5));

        Park park1 = new Park();
        Park park1WithAttractions = new Park(park1.new Attractions("Гонки", "11:00 - 22:00", 15));

        System.out.println(park1WithAttractions);
        System.out.println(parkWithAttractions);
    }
}
