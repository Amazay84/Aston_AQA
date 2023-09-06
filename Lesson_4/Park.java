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

    private class Attractions extends AbstractAttractions{

        public Attractions(String name, String startWorking, String endWorking, double cost) {
            super(name, startWorking, endWorking, cost);
        }
        @Override
        void printInfo(AbstractAttractions attractions) {
            System.out.println(attractions);
        }
    }

    public static class NestedAttractions extends AbstractAttractions {

        public NestedAttractions(String name, String startWorking, String endWorking, double cost) {
            super(name, startWorking, endWorking, cost);
        }
        @Override
        void printInfo(AbstractAttractions attractions) {
            System.out.println(attractions);
        }
    }
    AbstractAttractions anonymousAttractions = new AbstractAttractions("Комната страха", "23:00", "06:00", 5) {
        @Override
        void printInfo(AbstractAttractions attractions) {
            System.out.println("Анаонимный атракцион - " + attractions);
        }
    };

    public AbstractAttractions getAbstractAttractions() {
        AbstractAttractions abstractAttractions = new AbstractAttractions("Комната отдыха", "08:00", "07:45", 1) {
            @Override
            void printInfo(AbstractAttractions attractions) {
                System.out.println("Локальный атракцион - " + attractions);
            }
        };
        return abstractAttractions;
    }

    public static void main(String[] args) {
        Park park = new Park("7:00", "23:00");
        Park.Attractions attraction = new Park("7:00", "23:00").new Attractions("Батут", "10:00", "20:00", 4);
        Park parkWithAttractions = new Park("7:00", "23:00",
                park.new Attractions("Центрифуга", "10:00", park.endWorking, 5));

        Park.NestedAttractions nestedAttractions = new Park.NestedAttractions("Комната смеха", "10:00", "20:00", 5);

        System.out.println("Парк без атракционов - " + park);
        System.out.println("Атракцион в парке - " + attraction);
        System.out.println("Парк с атракционами - " + parkWithAttractions);
        System.out.println("Атракционы \"передвижные\" - " + nestedAttractions);
        park.anonymousAttractions.printInfo(park.anonymousAttractions);
        park.getAbstractAttractions().printInfo(park.getAbstractAttractions());
    }
}
