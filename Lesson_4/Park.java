import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attractions> attractionList = new ArrayList<>();
    public Park(Attractions attractions) {
       this.attractionList.add(attractions);
    }

    public Park() {
    }

    public List<Attractions> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attractions> attractionList) {
        this.attractionList = attractionList;
    }

    public void addAttractions(Attractions attractions) {
        attractionList.add(attractions);
    }

    @Override
    public String toString() {
        return "Park {" +
                " attractions = " + attractionList.toString() +
                " } ";
    }

    private static class Attractions {
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
            return "Attractions {" +
                    " name = '" + name + '\'' +
                    ", workingHours = '" + workingHours + '\'' +
                    ", cost = " + cost +
                    " } ";
        }
    }

    public static void main(String[] args) {
        Park park = new Park(new Attractions("Центрифуга", "10:00 - 20:00", 5));
        park.addAttractions(new Attractions("Цепная карусель", "10:00 - 20:00", 4.5));
        System.out.println(park);
        park.getAttractionList().stream().forEach(s -> System.out.println(s));
    }
}
