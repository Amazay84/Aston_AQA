import java.util.ArrayList;
import java.util.List;

public class Park {
    private String startWorking;
    private String endWorking;
    private Attractions attractions;
    public Park(String startWorking, String endWorking, Attractions attractions) {
        this.startWorking = startWorking;
        this.endWorking = endWorking;
        this.attractions = attractions;
    }

    public Park(String startWorking, String endWorking) {
        this.startWorking = startWorking;
        this.endWorking = endWorking;
    }

    public Attractions getAttractions() {
        return attractions;
    }

    public void setAttractions(Attractions attractions) {
        this.attractions = attractions;
    }

    public String getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(String startWorking) {
        this.startWorking = startWorking;
    }

    public String getEndWorking() {
        return endWorking;
    }

    public void setEndWorking(String endWorking) {
        this.endWorking = endWorking;
    }

    @Override
    public String toString() {
        return "Park{" +
                "startWorking='" + startWorking + '\'' +
                ", endWorking='" + endWorking + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    private class Attractions {
        private String name;
        private String startWorking;
        private String endWorking;
        private double cost;

        public Attractions(String name, String startWorking, String endWorking, double cost) {
            this.name = name;
            this.startWorking = startWorking;
            this.endWorking = endWorking;
            this.cost = cost;
        }

        public Attractions() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStartWorking() {
            return startWorking;
        }

        public void setStartWorking(String startWorking) {
            this.startWorking = startWorking;
        }

        public String getEndWorking() {
            return endWorking;
        }

        public void setEndWorking(String endWorking) {
            this.endWorking = endWorking;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attractions{" +
                    "name='" + name + '\'' +
                    ", startWorking='" + startWorking + '\'' +
                    ", endWorking='" + endWorking + '\'' +
                    ", cost=" + cost +
                    '}';
        }
        
    }

    public static class NestedAttractions {
        private String name;
        private String startWorking;
        private String endWorking;
        private double cost;

        public NestedAttractions(String name, String startWorking, String endWorking, double cost) {
            this.name = name;
            this.startWorking = startWorking;
            this.endWorking = endWorking;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "NestedAttractions{" +
                    "name='" + name + '\'' +
                    ", startWorking='" + startWorking + '\'' +
                    ", endWorking='" + endWorking + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }


    public static void main(String[] args) {
        Park park = new Park("7:00", "23:00");
        Park.Attractions attraction = new Park("7:00", "23:00").new Attractions("Батут", "10:00", "20:00", 4);

        Park parkWithAttractions = new Park("7:00", "23:00",
                park.new Attractions("Центрифуга", "10:00", park.endWorking, 5));

        Park.NestedAttractions nestedAttractions = new Park.NestedAttractions("Комната смеха", "10:00", "20:00", 5);

        System.out.println("Парк без атракционов - " + park + "\n");
        System.out.println("Атракцион в парке - " + attraction + "\n");
        System.out.println("Парк с атракционами - " + parkWithAttractions + "\n");
        System.out.println("Атракционы \"передвижные\" - " + nestedAttractions);
    }
}
